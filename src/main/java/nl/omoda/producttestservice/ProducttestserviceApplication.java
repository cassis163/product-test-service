package nl.omoda.producttestservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import nl.omoda.producttestservice.messaging.Channels;
import nl.omoda.producttestservice.service.ProductService;

@EnableBinding(Channels.class)
@SpringBootApplication
@EnableJpaRepositories
public class ProducttestserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducttestserviceApplication.class);
    }

    @Bean
    public CommandLineRunner demo(ProductService productService) {
        return (args) -> {
            productService.createProduct("Henk de turbotank");
        };
    }

}
