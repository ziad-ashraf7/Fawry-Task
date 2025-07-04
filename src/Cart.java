import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    public ArrayList<CartItem> getItems() {
        return items;
    }

    private ArrayList<CartItem> items = new ArrayList<>();

    public void add(Product product, int amount) {
        if(!product.isValidToHave(amount)) {
            throw new IllegalArgumentException("Product: " + product.getName()+ " is not available or expired");
        }
        for(CartItem item : items) {
            if(item.getProduct().equals(product)) {
                int newAmount = item.getAmount() + amount;
                if(!product.isValidToHave(newAmount)) {
                    throw new IllegalArgumentException("Product: " + product.getName()+ " is not available or expired");
                }
                item.setAmount(newAmount);
                return;
            }
        }
        items.add(new CartItem(product, amount));
    }


    public double getSubTotal() {
        double total = 0;
        for(CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
