package hu.oparin.bhexercise.repositories;

import hu.oparin.bhexercise.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    ArrayList<Category> findAll();
}
