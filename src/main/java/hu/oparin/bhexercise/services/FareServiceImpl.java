package hu.oparin.bhexercise.services;

import hu.oparin.bhexercise.models.Fare;
import hu.oparin.bhexercise.models.FareFilterRequest;
import hu.oparin.bhexercise.repositories.FareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public Fare findFare(Long id) {
        return fareRepository.findById(id).get();
    }

    @Override
    public Fare create(String carrier, String origin, String destination, String fareClassCode) {
        Fare newFare = new Fare(carrier, origin, destination, LocalDate.now(), LocalDate.now().plusDays(5), fareClassCode, 1);
        fareRepository.save(newFare);
        return newFare;
    }
}
