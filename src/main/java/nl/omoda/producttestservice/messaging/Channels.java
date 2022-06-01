package nl.omoda.producttestservice.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Channels {
    @Output("product")
    MessageChannel outgoingProduct();

    @Output("product-option")
    MessageChannel outgoingProductOption();
}
