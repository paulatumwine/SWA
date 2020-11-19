package shop.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import shop.order.service.OrderCustomerDTO;

@Component
public class CustomerServiceProxy {

    public static final String BASE_URL = "http://localhost:8081";

    @Autowired
    RestTemplate customerTemplate;

    public OrderCustomerDTO getOrderCustomer(String customerNumber) {
        ResponseEntity<OrderCustomerDTO> customer = customerTemplate.getForEntity(
                BASE_URL + "/customer/order/" + customerNumber, OrderCustomerDTO.class);
        return customer.getBody();
    }
}
