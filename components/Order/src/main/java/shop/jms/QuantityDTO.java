package shop.jms;

public class QuantityDTO {
	String productnumber;
	Integer quantity;

    public QuantityDTO() {
    }

    public QuantityDTO(String productnumber, Integer quantity) {
        this.productnumber = productnumber;
        this.quantity = quantity;
    }

    public String getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(String productnumber) {
        this.productnumber = productnumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
