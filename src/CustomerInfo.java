public class CustomerInfo {
    private int id;
    private String firstname;
    private String surname;
    private String size;
    private int quantity;
    private double totalPrice;

    public CustomerInfo(int id, String firstName, String surname) {
        this.id = id;
        this.firstname = firstName;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
