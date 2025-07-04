public abstract class Product {
    String name;
    int price;
    int quantity;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public abstract boolean isValidToHave(int order);
}
