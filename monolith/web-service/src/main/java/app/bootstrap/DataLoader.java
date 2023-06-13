package app.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.model.Customer;
import app.model.SalesManager;
import app.services.customer.CustomerServiceImpl;
import app.services.salesmanager.SalesManagerServiceImpl;

@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerServiceImpl customerService;
    private final SalesManagerServiceImpl salesManagerService;

    public DataLoader(CustomerServiceImpl customerService, SalesManagerServiceImpl salesManagerService) {
        this.customerService = customerService;
        this.salesManagerService = salesManagerService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loaded sales managers");
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Michael");
        customer1.setLastName("Weston");
        customerService.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Fiona");
        customer2.setLastName("Something");
        customerService.save(customer2);

        System.out.println("Loaded customers");

        SalesManager salesManager1 = new SalesManager();
        salesManager1.setId(1L);
        salesManager1.setFirstName("Tony");
        salesManager1.setLastName("Sale");
        salesManagerService.save(salesManager1);

        SalesManager salesManager2 = new SalesManager();
        salesManager2.setId(2L);
        salesManager2.setFirstName("Andy");
        salesManager2.setLastName("Something");
        salesManagerService.save(salesManager2);

        System.out.println("Loaded sales managers");

    }

    
}