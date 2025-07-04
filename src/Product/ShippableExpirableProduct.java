package Product;

import Product.Interfaces.Shippable;

import java.util.Date;

public class ShippableExpirableProduct extends ExpirableProduct implements Shippable {
    double weight;
    public ShippableExpirableProduct(String name, int price, int quantity, Date expireDate, double weight) {
        super(name, price, quantity, expireDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }


}
