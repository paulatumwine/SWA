package shop.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import shop.shopping.service.ProductDTO;

@Component
public class ProductCatalogServiceProxy {

    public static final String BASE_URL = "http://localhost:8082";

    @Autowired
    RestTemplate customerTemplate;

    public ProductDTO getProduct(String productnumber) {
        ResponseEntity<ProductDTO> customer = customerTemplate.getForEntity(
                BASE_URL + "/product/" + productnumber, ProductDTO.class);
        return customer.getBody();
    }
}
