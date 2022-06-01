package nl.omoda.producttestservice.messaging.config;

import java.util.ArrayList;
import java.util.Random;

import com.google.common.base.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import nl.omoda.producttestservice.entity.Product;
import nl.omoda.producttestservice.messaging.event.CrudEvent;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Configuration
public abstract class MessageConfig {
    private static Logger logger = LoggerFactory.getLogger(MessageConfig.class);

    private static Flux<Message<CrudEvent<Product>>> productsFlux = Flux.create(sink -> {
        myEventProcessor.register(
          new MyEventListener<String>() {

            public void onDataChunk(List<String> chunk) {
              for(String s : chunk) {
                sink.next(s);
              }
            }

            public void processComplete() {
                sink.complete();
            }
        });
    });

    // Create an output binder to send messages to `topic-one` using a Supplier
    // bean.
    // @Bean
    // public Supplier<Flux<Message<String>>> sendMessageToProductTopic() {
    //     return () -> Flux.<Message<String>>generate(
    //             sink -> {
    //                 try {
    //                     Thread.sleep(10000);
    //                 } catch (InterruptedException e) {
    //                     // Stop sleep earlier.
    //                 }

    //                 Message<String> message = MessageBuilder.withPayload("message-" + this.rand.nextInt(1000)).build();
    //                 this.logger.info(
    //                         "Sending a message via the output binder to topic-one! Payload: "
    //                                 + message.getPayload());
    //                 sink.next(message);
    //             })
    //             .subscribeOn(Schedulers.boundedElastic());
    // }

    @Bean
    public static Supplier<Flux<Message<CrudEvent<Product>>>> sendMessageToProductTopic() {
        return () -> MessageConfig.productsFlux.subscribeOn(Schedulers.boundedElastic());
    }

    public static Message<CrudEvent<Product>> createProductMessage(Product product) {
        productsFlux.publish();
    }
}
