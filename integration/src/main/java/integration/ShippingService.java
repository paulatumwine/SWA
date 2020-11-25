package integration;

public class ShippingService {
	public Order print(Order order) throws Exception {
		System.out.println("ShippingService: " + order);
		return order;
	}

}
