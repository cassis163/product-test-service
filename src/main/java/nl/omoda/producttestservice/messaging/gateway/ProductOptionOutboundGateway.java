package nl.omoda.producttestservice.messaging.gateway;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

import nl.omoda.producttestservice.entity.ProductOption;
import nl.omoda.producttestservice.messaging.Channels;
import nl.omoda.producttestservice.messaging.event.CrudEvent;

@MessagingGateway(defaultRequestChannel = Channels.PRODUCT_OPTION)
public interface ProductOptionOutboundGateway {
    void sendToPubsub(Message<CrudEvent<ProductOption>> message);
}
