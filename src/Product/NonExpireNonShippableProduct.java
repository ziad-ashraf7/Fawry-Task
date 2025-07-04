package Product;

public class NonExpireNonShippableProduct extends Product {
    public NonExpireNonShippableProduct(String name, int price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isAvailableToOrder(int order) {
        return order <= this.quantity;
    }
}
