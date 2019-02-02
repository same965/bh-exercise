package hu.oparin.bhexercise.repositories;

import hu.oparin.bhexercise.models.Fare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRepository extends CrudRepository<Fare, Long> {
}
