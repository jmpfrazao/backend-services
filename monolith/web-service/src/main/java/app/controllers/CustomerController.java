package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.services.customer.CustomerService;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/customers", "/customers/index", "/customers/index.html"})
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());

        return "customers/index";
    }
}
