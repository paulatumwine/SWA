package shop.order.integration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shop.order.service.OrderCustomerDTO;

@RibbonClient(name = "customers-service")
@FeignClient("customers-service")
public interface CustomerFeignClient {
    @GetMapping("/ordercustomer/{customerNumber}")
    OrderCustomerDTO getOrderCustomer(@PathVariable("customerNumber") String customerNumber);
}
