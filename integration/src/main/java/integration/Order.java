package integration;

public class Order {
    String ordernumber;
    Double amount;

    public Order(String ordernumber, Double amount) {
        this.ordernumber = ordernumber;
        this.amount = amount;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ordernumber=" + ordernumber +
                ", amount=" + amount +
                '}';
    }
}
