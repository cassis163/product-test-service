package nl.omoda.producttestservice.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import nl.omoda.producttestservice.entity.Product;
import nl.omoda.producttestservice.entity.ProductOption;
import nl.omoda.producttestservice.messaging.event.CrudEvent;

@Service
public class Publisher {
    private final MessageChannel productChannel;
    private final MessageChannel productOptionChannel;

    private static final Logger logger = LoggerFactory.getLogger(Publisher.class);

    public Publisher(Channels channels) {
        this.productChannel = channels.outgoingProduct();
        this.productOptionChannel = channels.outgoingProductOption();
    }

    public void publishProductMessage(CrudEvent<Product> event) {
        logger.info("Publishing product message!");

        productChannel.send(this.createMessage(event));
    }

    public void publishProductOptionMessage(CrudEvent<ProductOption> event) {
        logger.info("Publishing product-option message!");

        productOptionChannel.send(this.createMessage(event));
    }

    private <T>Message<CrudEvent<T>> createMessage(CrudEvent<T> event) {
        return MessageBuilder.withPayload(event).build();
    }
}

