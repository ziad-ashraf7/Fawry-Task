package Product;

import Product.Interfaces.Shippable;

public class ShippableProduct extends Product implements Shippable {
    double weight;
    public ShippableProduct(String name,int price, int quantity , double weight) {
        super(name , price, quantity);
        this.weight = weight;
    }


    @Override
    public boolean isAvailableToOrder(int order) {
        return order <= this.quantity;
    }


    @Override
    public double getWeight() {
        return weight;
    }
}
