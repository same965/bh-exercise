package hu.oparin.bhexercise.services;

import hu.oparin.bhexercise.models.Fare;
import hu.oparin.bhexercise.models.FareFilterRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface FareService {
    List<Fare> filter(FareFilterRequest fareFilterRequest);
    boolean filteredListIsEmpty(FareFilterRequest fareFilterRequest);
    Fare findFare(Long id);
    Fare create(String carrier, String origin, String destination, LocalDate validFrom, LocalDate validTo, String fareClassCode);
}
