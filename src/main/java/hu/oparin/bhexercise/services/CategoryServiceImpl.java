package hu.oparin.bhexercise.services;

import hu.oparin.bhexercise.models.Category;
import hu.oparin.bhexercise.models.Fare;
import hu.oparin.bhexercise.repositories.CategoryRepository;
import hu.oparin.bhexercise.repositories.FareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Fare fare, LocalDate validFrom, LocalDate validTo) {
        Category newCategory = new Category(fare, 3, validFrom, validTo);
        categoryRepository.save(newCategory);
        return newCategory;
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }
}
