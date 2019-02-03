package hu.oparin.bhexercise.controllers;

import hu.oparin.bhexercise.factories.MessageFactory;
import hu.oparin.bhexercise.models.Category;
import hu.oparin.bhexercise.models.ErrorMessage;
import hu.oparin.bhexercise.models.Fare;
import hu.oparin.bhexercise.services.CategoryService;
import hu.oparin.bhexercise.services.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;
    private final FareService fareService;

    @Autowired
    public CategoryController(CategoryService categoryService, FareService fareService) {
        this.categoryService = categoryService;
        this.fareService = fareService;
    }

    @PostMapping("/category/create")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody Category category) {
        if (category.getFare().getId() == null) {
            ErrorMessage nullFare = MessageFactory.nullFare();
            return new ResponseEntity<>(nullFare, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(categoryService.create(fareService.findFare(category.getFare().getId()), category.getValidFrom(), category.getValidTo()), HttpStatus.CREATED);
        }
    }


}
