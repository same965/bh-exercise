package hu.oparin.bhexercise.services;

import hu.oparin.bhexercise.models.Category;
import hu.oparin.bhexercise.models.Fare;

import java.time.LocalDate;
import java.util.List;

public interface CategoryService {
    Category create(Fare fare, LocalDate validFrom, LocalDate validTo);
    List<Category> listCategories();
    Category findCategory(Long id);
    void delete(Long id);
}
