package integration;

public class NextDayShippingService {
	public Order print(Order order) throws Exception {
		System.out.println(this.getClass().toString() + ": " + order);
		return order;
	}

}
