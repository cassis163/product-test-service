package nl.omoda.producttestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProducttestserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProducttestserviceApplication.class, args);
	}

}
