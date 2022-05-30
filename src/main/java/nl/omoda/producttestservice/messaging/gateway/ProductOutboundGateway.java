package nl.omoda.producttestservice.messaging.gateway;

import org.springframework.integration.annotation.MessagingGateway;

import nl.omoda.producttestservice.messaging.Channels;

@MessagingGateway(defaultRequestChannel = Channels.PRODUCT)
public interface ProductOutboundGateway {
    void sendToPubsub(String text);
}
