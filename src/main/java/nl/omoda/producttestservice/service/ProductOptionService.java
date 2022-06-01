package nl.omoda.producttestservice.service;

import org.springframework.stereotype.Service;

import nl.omoda.producttestservice.entity.Color;
import nl.omoda.producttestservice.entity.Product;
import nl.omoda.producttestservice.entity.ProductOption;
import nl.omoda.producttestservice.messaging.Publisher;
import nl.omoda.producttestservice.messaging.event.CrudEvent;
import nl.omoda.producttestservice.messaging.event.CrudType;
import nl.omoda.producttestservice.repository.ProductOptionRepository;

@Service
public class ProductOptionService {
    private final ProductOptionRepository repository;
    private final Publisher publisher;

    public ProductOptionService(ProductOptionRepository productOptionRepository, Publisher publisher) {
        this.repository = productOptionRepository;
        this.publisher = publisher;
    }

    public ProductOption createProductOption(Product product, Color color, String name) {
        ProductOption productOption = new ProductOption(product, color, name);
        this.repository.save(productOption);
        this.publishPubSubMessage(new CrudEvent<ProductOption>(CrudType.CREATE, productOption));

        return productOption;
    }

    private void publishPubSubMessage(CrudEvent<ProductOption> event) {
        this.publisher.publishProductOptionMessage(event);
    }
}
