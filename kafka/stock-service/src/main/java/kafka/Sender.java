package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.order.prepared}")
    private String topicOk;

    @Value("${app.topic.product.out}")
    private String topicNotOk;

    public void send(){
        String message = "Order Prepared Event";
    	System.out.println("sending message="+message+" to topic="+ topicOk);
        kafkaTemplate.send(topicOk, message);

        message = "Product Out of Stock Event";
        System.out.println("sending message="+message+" to topic="+ topicNotOk);
        kafkaTemplate.send(topicNotOk, message);
    }
}
