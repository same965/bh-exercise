package hu.oparin.bhexercise.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FareController {

    @GetMapping("/fare/hello")
    public String greet() {
        return "Hello World";
    }
}
