package shop.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import shop.products.service.ProductCatalogService;

@Component
public class StockMessageListener {

    @Autowired
    ProductCatalogService productCatalogService;

    @JmsListener(destination = "stockQueue")
    public void receiveMessage(final QuantityDTO quantityDTO) {
        System.out.println("JMS receiver received message: product number: " + quantityDTO.getProductnumber() +
                ", quantity: " + quantityDTO.getQuantity());
        productCatalogService.setStock(quantityDTO.getProductnumber(), quantityDTO.getQuantity());
    }
}

