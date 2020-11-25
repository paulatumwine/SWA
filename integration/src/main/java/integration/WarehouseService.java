package integration;

public class WarehouseService {
    public Order print(Order order) throws Exception {
        System.out.println("WarehouseService: " + order);
        return order;
    }

}
