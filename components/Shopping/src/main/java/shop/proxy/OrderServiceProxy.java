package shop.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import shop.shopping.service.ProductDTO;
import shop.shopping.service.ShoppingCartDTO;

@Component
public class OrderServiceProxy {

    public static final String BASE_URL = "http://localhost:8084";

    @Autowired
    RestTemplate customerTemplate;

    public ProductDTO createOrder(ShoppingCartDTO cartDTO) {
        ResponseEntity<ProductDTO> customer = customerTemplate.getForEntity(
                BASE_URL + "/order/" + cartDTO.getCartid(), ProductDTO.class);
        return customer.getBody();
    }
}
