package Cart;

import Product.Interfaces.Shippable;
import Product.Product;

public class CartItem {
    private Product product;
    private int amount;

    public CartItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    // Getters
    public Product getProduct() {
        return product;
    }
    public int getAmount() {
        return amount;
    }
    public double getSubtotalPrice(){
        return product.getPrice() * amount;
    }
    public double getShippingPrice(){
        return product instanceof Shippable ? ((Shippable)product).getWeight() * amount * Shippable.RATE_PER_KG : 0;
    }
    public double getTotalPrice(){
        return getSubtotalPrice() + getShippingPrice();
    }

    // Setter
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
