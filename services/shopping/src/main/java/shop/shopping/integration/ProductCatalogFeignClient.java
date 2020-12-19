package shop.shopping.integration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shop.shopping.service.ProductDTO;

@RibbonClient(name = "product-service")
@FeignClient("product-service")
public interface ProductCatalogFeignClient {
    @GetMapping("/product/{productnumber}")
    ProductDTO getProduct(@PathVariable("productnumber") String productnumber);
}
