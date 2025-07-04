import java.awt.*;
import java.util.ArrayList;

public class ECommerceSystem {
    ShippingService shippingService = new ShippingService();
    void checkOut(Customer customer, Cart cart) {

        if (cart.getItems().isEmpty()) {
            throw new IllegalStateException("Can't checkout with empty cart");
        }

        ArrayList<CartItem> items = cart.getItems();
        ArrayList<Shippable> shippableItems = new ArrayList<>();

        for(CartItem item : items) {
            if(!item.getProduct().isValidToHave(item.getAmount())){
                throw new IllegalArgumentException("Product: " + item.getProduct().getName()+ " is not available or expired");
            }
        }


        for(CartItem item : items) {
            if(item.getProduct() instanceof Shippable){
                shippableItems.add((Shippable)item.getProduct());
            }
        }

        double subtotal = cart.getSubTotal();
        double shippingFees = getShippingFees(shippableItems);
        double totalcost = subtotal + shippingFees;

        if(customer.getBalance() < totalcost){
            throw new IllegalArgumentException("Customer doesn't have enough Balance");
        }

        if(!shippableItems.isEmpty()){
            shippingService.shipProducts(shippableItems, items);
        }

        printReceipt(items);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping Fees: " + shippingFees);
        System.out.println("Amount:  " + totalcost);

    }

    private void printReceipt(ArrayList<CartItem> items) {
        System.out.println("** Checking receipt **");
        for(CartItem item : items) {
            String name = item.getProduct().getName();
            double price = item.getTotalPrice();
            int amount = item.getAmount();

            System.out.println(amount+"x "+ name + "           " + price);
        }

        System.out.println("--------------------------------");
    }

    private int getShippingFees(ArrayList<Shippable> shippableItems) {
        double totalWeight = getTotalShippingWeight(shippableItems);
        return (int)(2.7 * totalWeight)/100;
    }

    private double getTotalShippingWeight(ArrayList<Shippable> shippableItems) {
        double totalWeight = 0;
        for(Shippable shippable : shippableItems){
            totalWeight += shippable.getWeight();
        }
        return totalWeight;
    }


}
