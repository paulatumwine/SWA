package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import shop.customers.service.AddressDTO;
import shop.customers.service.CustomerDTO;
import shop.order.service.OrderDTO;
import shop.products.service.ProductDTO;
import shop.shopping.service.CartLineDTO;
import shop.shopping.service.ShoppingCartDTO;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;

    public static final String BASE_URL = "http://localhost:8080";

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		//create customer
		CustomerDTO customerDto = new CustomerDTO("101","Frank","Brown","fBrown@Hotmail.com","123456");
		AddressDTO addressDTO = new AddressDTO("1000 N main Street", "Fairfield","52557","USA");
		customerDto.setAddress(addressDTO);
		//call the customer component to add the customer
        restTemplate.postForLocation(BASE_URL + "/customer", customerDto);

		// get customer
		//call the customer component to get the customer with id 101 and print the result
        ResponseEntity<CustomerDTO> customer = restTemplate.getForEntity(BASE_URL + "/customer/101", CustomerDTO.class);
        System.out.println(customer.getBody());

		//create products
		
		//call the product component to create the first product
        restTemplate.postForLocation(
                String.format("%s/product/%s/%s/%.2f", BASE_URL, "101", "The first product", 31.99), null);
		//call the product component to create the second product
        restTemplate.postForLocation(
                String.format("%s/product/%s/%s/%.2f", BASE_URL, "102", "The second product", 13.49), null);

		//set stock	
		//call the product component to set the stock for the first product
        restTemplate.postForLocation(
                String.format("%s/product/stock/%s/%d/%s", BASE_URL, "101", 7, "Denver"), null);

		//get a product
		//call the product component to get the the first product and print the result
        ResponseEntity<ProductDTO> productOne = restTemplate.getForEntity(BASE_URL + "/product/101", ProductDTO.class);
        ProductDTO product = productOne.getBody();
        System.out.println(product.getProductnumber() + " - " + product.getDescription() + " - " + product.getPrice());
		
		// add products to the shoppingcart
		//call the shopping component to add the first product to the cart
        String cartId = "1";
        restTemplate.postForLocation(BASE_URL + "/cart/" + cartId + "/101/1", null);
		//call the shopping component to add the second product to the cart
        restTemplate.postForLocation(BASE_URL + "/cart/" + cartId + "/102/1", null);

		//get the shoppingcart
		//call the shopping component to get the cart and print the result
        ResponseEntity<ShoppingCartDTO> cartResponse = restTemplate.getForEntity(BASE_URL + "/cart/" + cartId, ShoppingCartDTO.class);
        ShoppingCartDTO cart = cartResponse.getBody();
        System.out.println(cart.getCartid() + " - " + cart.getTotalPrice());

        //checkout the cart
		//call the shopping component to checkout the cart
        restTemplate.postForLocation(BASE_URL + "/cart/checkout/" + cartId, null);

		//get the order
		//call the order component to get the order and print the result
        String orderId = cartId;
        ResponseEntity<OrderDTO> orderResponse = restTemplate.getForEntity(BASE_URL + "/order/" + orderId, OrderDTO.class);
        orderResponse.getBody().print();

		//add customer to order
		//call the order component to add a customer to the order
        restTemplate.postForLocation(BASE_URL + "/order/setCustomer/" + orderId + "/101", null);
		
		//confirm the order
		//call the order component to confirm the order
        restTemplate.postForLocation(BASE_URL + "/order/" + orderId, null);
		
		//get the order
		//call the order component to get the order and print the result
        orderResponse = restTemplate.getForEntity(BASE_URL + "/order/" + orderId, OrderDTO.class);
        orderResponse.getBody().print();
		
	}


}
