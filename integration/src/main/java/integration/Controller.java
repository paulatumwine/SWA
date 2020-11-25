package integration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	@Autowired
	private GreetingGateway gateway;
	
	@RequestMapping("/order")
	public Order getGreeting() {
        Order order = new Order("H-234-X56",600.65);
        Message<Order> orderMessage =  MessageBuilder.withPayload(order).build();
		Order result = gateway.handleRequest(orderMessage);
		return result;
	}
}
