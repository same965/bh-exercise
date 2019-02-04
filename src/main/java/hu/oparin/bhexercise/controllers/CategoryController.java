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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/category/list")
    public List<Category> categories() {
        return categoryService.listCategories();
    }

    @GetMapping("/category/{id}")
    public Category findCategory(@PathVariable(value = "id") Long id) {
        return categoryService.findCategory(id);
    }

    @DeleteMapping("/category/{id}/delete")
    public List<Category> deleteCategory(@PathVariable(value = "id") Long id) {
        categoryService.delete(id);
        return categoryService.listCategories();
    }

    @PutMapping("/category/{id}/update")
    public Category updateCategory(@PathVariable(value = "id") Long id, @Valid @RequestBody Category category) {
        categoryService.update(id, category.getCategoryNumber(), category.getValidFrom(), category.getValidTo());
        return categoryService.findCategory(id);
    }

}
