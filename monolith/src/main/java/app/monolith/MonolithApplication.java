package app.monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.monolith.controllers.GroupController;

@SpringBootApplication
public class MonolithApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MonolithApplication.class, args);
		GroupController groupController = (GroupController) ctx.getBean("groupController");

		String greeting = groupController.sayHello();

		System.out.println(greeting);
	}

}
