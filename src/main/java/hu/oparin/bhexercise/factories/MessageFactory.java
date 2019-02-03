package hu.oparin.bhexercise.factories;

import hu.oparin.bhexercise.models.ErrorMessage;
import org.springframework.stereotype.Component;

@Component
public class MessageFactory {
    public static final String invalidFilter = "Both filters should have been given";
    public static final String noResult = "No such fare";
    public static final String missingFields = "At least one of the fields is missing";
    public static final String nullFare = "Fare is missing";

    public MessageFactory() {
    }

    public static ErrorMessage invalidFilter() {
        return new ErrorMessage(invalidFilter);
    }

    public static ErrorMessage noResult() {
        return new ErrorMessage(noResult);
    }

    public static ErrorMessage missingFields() {
        return new ErrorMessage(missingFields);
    }

    public static ErrorMessage nullFare() {
        return new ErrorMessage(nullFare);
    }
}
