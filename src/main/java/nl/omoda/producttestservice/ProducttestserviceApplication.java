package nl.omoda.producttestservice;

import java.util.Random;

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
    private final int MIN_CREATION_DELAY = (int) 5e2;
    private final int MAX_CREATION_DELAY = (int) 3e3;

    private Random random = new Random();

    public static void main(String[] args) {
        SpringApplication.run(ProducttestserviceApplication.class);
    }

    @Bean
    public CommandLineRunner demo(ProductService productService) {
        return (args) -> {
            int productIndex = 1;
            while (true) {
                Thread.sleep(this.random.nextInt(this.MIN_CREATION_DELAY, this.MAX_CREATION_DELAY));
                productService.createProduct(String.format("Product%s", String.valueOf(productIndex)));
                productIndex++;
            }
        };
    }

}
