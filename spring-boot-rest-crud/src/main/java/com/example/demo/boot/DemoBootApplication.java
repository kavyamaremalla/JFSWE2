package com.example.demo.boot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "CRUD Operations on a student",
                description = "creates, fetches, updates, deletes a Student",
                version = "1.0",

                contact = @Contact(
                        name = "Principal : Matthew Perry",
                        email = "matthew@gmail.com",
                        url = "www.highshool.canada.com"
                ),
                license = @License(name = "Apache 1.0", url = "https://www.apache.com")
        )
        , servers = {@Server(url = "https:myServer1.com"), @Server(url = "https:myServer2.com")}
        , externalDocs = @ExternalDocumentation(description = "refer to this for more info www.gooogle.com")
)
public class DemoBootApplication {

    public static void main(String[] args) {
//		ApplicationContext context =
        SpringApplication.run(DemoBootApplication.class, args);
//		String[] beans = context.getBeanDefinitionNames();
//		for (String bean:beans) {
//			System.out.println(bean);
//		}
    }

}
