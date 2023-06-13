package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import app.services.salesmanager.SalesManagerService;
import org.springframework.ui.Model;

@Controller
public class SalesManagerController {

    private final SalesManagerService salesManagerService;

    public SalesManagerController(SalesManagerService salesManagerService) {
        this.salesManagerService = salesManagerService;
    }

    @GetMapping({"/salesmanagers", "/salesmanagers/index", "/salesmanagers/index.html"})
    public String listSalesManagers(Model model) {
        model.addAttribute("salesmanagers", salesManagerService.findAll());

        return "salesmanagers/index";
    }
}

