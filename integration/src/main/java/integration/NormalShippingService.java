package integration;

public class NormalShippingService {
	public Order print(Order order) throws Exception {
		System.out.println(this.getClass().toString() + ": " + order);
		return order;
	}

}
