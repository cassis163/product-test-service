package nl.omoda.producttestservice.service;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.omoda.producttestservice.entity.Color;
import nl.omoda.producttestservice.entity.Product;
import nl.omoda.producttestservice.messaging.config.MessageConfig;
import nl.omoda.producttestservice.messaging.event.CrudEvent;
import nl.omoda.producttestservice.messaging.event.CrudType;
import nl.omoda.producttestservice.repository.ColorRepository;
import nl.omoda.producttestservice.repository.ProductRepository;

@Service
public class ProductService {
    private static final int AMOUNT_OF_OPTIONS = 4;

    private static final Random randomizer = new Random();

    private final ProductRepository repository;
    private final ColorRepository colorRepository;
    private final ProductOptionService productOptionService;

    @Autowired
    private MessageConfig messageConfig;

    public ProductService(ProductRepository productRepository, ColorRepository colorRepository, ProductOptionService productOptionService) {
        this.repository = productRepository;
        this.colorRepository = colorRepository;
        this.productOptionService = productOptionService;
    }

    public Product createProduct(String name) {
        Product product = new Product(name);
        this.repository.save(product);
        this.publishPubSubMessage(product);
        this.createProductOptions(product);

        return product;
    }

    private void createProductOptions(Product product) {
        for (int i = 0; i < ProductService.AMOUNT_OF_OPTIONS; i++) {
            this.productOptionService.createProductOption(product, this.getRandomColor(), this.getProductOptionName(i));
        }
    }

    private Color getRandomColor() {
        List<Color> colors = Lists.newArrayList(this.colorRepository.findAll());

        return colors.get(randomizer.nextInt(colors.size()));
    }

    private String getProductOptionName(int index) {
        return String.format("Option %s", String.valueOf(index + 1));
    }

    private void publishPubSubMessage(Product product) {
        CrudEvent<Product> event = new CrudEvent<Product>(CrudType.CREATE, product);
        this.messageConfig.sendMessageToProductTopic(event);
    }
}
