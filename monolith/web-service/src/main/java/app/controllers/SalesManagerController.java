package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalesManagerController {

    @GetMapping({"/salesmanagers", "/salesmanagers/index", "/salesmanagers/index.html"})
    public String listSalesManagers() {
        return "salesmanagers/index";
    }
}
