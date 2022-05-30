package nl.omoda.producttestservice.messaging.config;

import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

import nl.omoda.producttestservice.messaging.Channels;
import nl.omoda.producttestservice.messaging.Topics;

@Configuration
public class MessageConfig {
    @Bean
    @ServiceActivator(inputChannel = Channels.PRODUCT)
    public MessageHandler productMessageSender(PubSubTemplate pubsubTemplate) {
        return new PubSubMessageHandler(pubsubTemplate, Topics.PRODUCT);
    }

    @Bean
    @ServiceActivator(inputChannel = Channels.PRODUCT_OPTION)
    public MessageHandler productOptionMessageSender(PubSubTemplate pubsubTemplate) {
        return new PubSubMessageHandler(pubsubTemplate, Topics.PRODUCT_OPTION);
    }
}
