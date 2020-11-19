package shop.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {
	@Autowired
	JmsTemplate jmsTemplate;

	public void sendJMSMessage(QuantityDTO quantityDTO) {
		System.out.println("Sending a stock update - product number: " + quantityDTO.getProductnumber()
                + ", quantity: " + quantityDTO.getQuantity());
		jmsTemplate.convertAndSend("stockQueue", quantityDTO);
	}
}
