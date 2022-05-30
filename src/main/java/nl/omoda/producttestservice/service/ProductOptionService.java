package nl.omoda.producttestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.omoda.producttestservice.entity.Color;
import nl.omoda.producttestservice.entity.Product;
import nl.omoda.producttestservice.entity.ProductOption;
import nl.omoda.producttestservice.messaging.gateway.ProductOptionOutboundGateway;
import nl.omoda.producttestservice.repository.ProductOptionRepository;

@Service
public class ProductOptionService {
    private final ProductOptionRepository repository;

    @Autowired
    private ProductOptionOutboundGateway messagingGateway;

    public ProductOptionService(ProductOptionRepository productOptionRepository) {
        this.repository = productOptionRepository;
    }

    public ProductOption createProductOption(Product product, Color color, String name) {
        ProductOption productOption = new ProductOption(product, color, name);
        this.repository.save(productOption);
        this.publishPubSubMessage();

        return productOption;
    }

    private void publishPubSubMessage() {
        this.messagingGateway.sendToPubsub("test");
    }
}
