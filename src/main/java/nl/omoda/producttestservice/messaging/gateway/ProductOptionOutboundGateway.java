package nl.omoda.producttestservice.messaging.gateway;

import org.springframework.integration.annotation.MessagingGateway;

import nl.omoda.producttestservice.messaging.Channels;

@MessagingGateway(defaultRequestChannel = Channels.PRODUCT_OPTION)
public interface ProductOptionOutboundGateway {
    void sendToPubsub(String text);
}
