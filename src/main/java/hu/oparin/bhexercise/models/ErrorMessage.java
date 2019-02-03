package hu.oparin.bhexercise.models;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
