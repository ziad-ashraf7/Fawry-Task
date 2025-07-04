import java.io.Serializable;

public class ShippableProduct extends Product implements Shippable {
    double weight;
    public ShippableProduct(String name,int price, int quantity , double weight) {
        super(name , price, quantity);
        this.weight = weight;
    }


    @Override
    public boolean isValidToHave(int order) {
        return order <= this.quantity;
    }


    @Override
    public double getWeight() {
        return weight;
    }
}
