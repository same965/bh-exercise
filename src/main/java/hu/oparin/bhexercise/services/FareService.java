package hu.oparin.bhexercise.services;

import hu.oparin.bhexercise.models.Fare;
import hu.oparin.bhexercise.models.FareFilterRequest;

import java.util.ArrayList;
import java.util.List;

public interface FareService {
    public List<Fare> filter(FareFilterRequest fareFilterRequest);
    public boolean filteredListIsEmpty(FareFilterRequest fareFilterRequest);
}
