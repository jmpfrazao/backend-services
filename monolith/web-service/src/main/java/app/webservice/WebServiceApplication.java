package app.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.webservice.controllers.GroupController;

@SpringBootApplication
public class WebServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(WebServiceApplication.class, args);
		GroupController groupController = (GroupController) ctx.getBean("groupController");

		String greeting = groupController.sayHello();

		System.out.println(greeting);
	}

}
