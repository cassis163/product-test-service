package nl.omoda.productestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProductestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductestserviceApplication.class, args);
	}

}
