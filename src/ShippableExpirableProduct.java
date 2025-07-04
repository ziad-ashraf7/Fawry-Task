import java.io.Serializable;
import java.util.Date;

public class ShippableExpirableProduct extends ExpireProduct implements Shippable{
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
