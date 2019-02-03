package hu.oparin.bhexercise.controllers;

import hu.oparin.bhexercise.factories.MessageFactory;
import hu.oparin.bhexercise.models.ErrorMessage;
import hu.oparin.bhexercise.models.Fare;
import hu.oparin.bhexercise.models.FareFilterRequest;
import hu.oparin.bhexercise.services.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;

@RestController
public class FareController extends ResponseEntityExceptionHandler {

    private final FareService fareService;

    @Autowired
    public FareController(FareService fareService) {
        this.fareService = fareService;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/fare/hello")
    public String greet() {
        return "Hello World";
    }

    @PostMapping("/fare/filter")
    public ResponseEntity<Object> farefilter(@Valid @RequestBody FareFilterRequest fareFilterRequest) {
        if (fareFilterRequest.getOrigin() == null || fareFilterRequest.getDestination() == null || fareFilterRequest == null) {
            ErrorMessage invalidfilter = MessageFactory.invalidFilter();
            return new ResponseEntity<>(invalidfilter, HttpStatus.BAD_REQUEST);
        } else if (fareService.filteredListIsEmpty(fareFilterRequest)) {
            ErrorMessage emptyList = MessageFactory.noResult();
            return new ResponseEntity<>(emptyList, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(fareService.filter(fareFilterRequest), HttpStatus.OK);
        }
    }

    @PostMapping("/fare/create")
    public ResponseEntity<Object> createFare(@Valid @RequestBody Fare fare) {
        if (fare.getCarrier() == null || fare.getOrigin() == null || fare.getDestination() == null
                || fare.getFareClassCode() == null) {
            ErrorMessage missingField = MessageFactory.missingFields();
            return new ResponseEntity<>(missingField, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(fareService.create(fare.getCarrier(), fare.getOrigin(), fare.getDestination(), fare.getFareClassCode()), HttpStatus.CREATED);
        }
    }
}
