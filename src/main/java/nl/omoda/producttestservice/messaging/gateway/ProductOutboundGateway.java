package nl.omoda.producttestservice.messaging.gateway;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

import nl.omoda.producttestservice.entity.Product;
import nl.omoda.producttestservice.messaging.Channels;
import nl.omoda.producttestservice.messaging.event.CrudEvent;

@MessagingGateway(defaultRequestChannel = Channels.PRODUCT)
public interface ProductOutboundGateway {
    void sendToPubsub(Message<CrudEvent<Product>> message);
}
