package Cart;

import Product.Interfaces.Shippable;
import Product.Product;

import java.util.ArrayList;

public class Cart {
    // List of the Cart items
    private ArrayList<CartItem> items = new ArrayList<>();


    public void add(Product product, int amount) {
        if(!product.isAvailableToOrder(amount)) {
            throw new IllegalArgumentException("Product.Product: " + product.getName()+ " is not available or expired");
        }
        for(CartItem item : items) {
            if(item.getProduct().equals(product)) {
                int newAmount = item.getAmount() + amount;
                if(!product.isAvailableToOrder(newAmount)) {
                    throw new IllegalArgumentException("Product.Product: " + product.getName()+ " is not available or expired");
                }
                item.setAmount(newAmount);
                return;
            }
        }
        items.add(new CartItem(product, amount));
    }


    // Getters
    public ArrayList<CartItem> getItems() {
        return items;
    }

    // getting the total of (Subtotal) cost for every item in the cart
    public double getSubTotal() {
        double total = 0;
        for(CartItem item : items) {
            total += item.getSubtotalPrice();
        }
        return total;
    }

    // Computing the total price of the Shippable items in the cart
    public double getShippedPrice(){
        double total = 0;
        for(CartItem item : items) {

            // Asking if the item is Shippable or not
            if(item.getProduct() instanceof Shippable)
                total += item.getShippingPrice();

        }
        return total;
    }


    //Computing the total price of the cart (subTotal + shipping fees)
    public double getTotalPrice() {
        double total = 0;
        for(CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }


    // Computing the total Shipping weight for shippable items
    public double getTotalShippedWeight(){
        double total = 0;
        for(CartItem item : items) {
            if(item.getProduct() instanceof Shippable){
                total += ((Shippable)item.getProduct()).getWeight() * item.getAmount();
            }
        }
        return total;
    }

    public ArrayList<Shippable> getShippableItems(){
        ArrayList<Shippable> shippables = new ArrayList<>();
        for(CartItem item : items) {
            if(item.getProduct() instanceof Shippable){
                shippables.add((Shippable)item.getProduct());
            }
        }
        return shippables;
    }


    public boolean isEmpty() {
        return items.isEmpty();
    }




}
