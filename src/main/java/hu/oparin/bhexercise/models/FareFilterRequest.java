package hu.oparin.bhexercise.models;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;

@Component
public class FareFilterRequest {
    @Size(max = 3)
    private String origin;
    @Size(max = 3)
    private String destination;

    public FareFilterRequest() {
    }

    public FareFilterRequest(@Size(max = 3) String origin, @Size(max = 3) String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
