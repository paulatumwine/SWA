package integration;

public class OrderRouter {
    public String route(Order order) {
        String destinationChannel = null;
        if (order.getAmount() > 175D)
            destinationChannel = "nextDayShippingChannel";
        else
            destinationChannel = "normalShippingChannel";
        return destinationChannel;
    }
}
