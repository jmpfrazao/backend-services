package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping({"/customers", "/customers/index", "/customers/index.html"})
    public String listCustomers() {
        return "customers/index";
    }
}