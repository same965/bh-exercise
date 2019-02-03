package hu.oparin.bhexercise.services;

import hu.oparin.bhexercise.models.Fare;
import hu.oparin.bhexercise.models.FareFilterRequest;
import hu.oparin.bhexercise.repositories.FareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FareServiceImpl implements FareService{

    private final FareRepository fareRepository;

    @Autowired
    public FareServiceImpl(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }

    @Override
    public List<Fare> filter(FareFilterRequest fareFilterRequest) {
        return fareRepository.findAllByOriginAndDestination(fareFilterRequest.getOrigin(), fareFilterRequest.getDestination());
    }

    @Override
    public boolean filteredListIsEmpty(FareFilterRequest fareFilterRequest) {
        return filter(fareFilterRequest).isEmpty();
    }
}
