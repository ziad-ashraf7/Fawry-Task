package Services;

import Cart.Cart;
import Cart.CartItem;
import Customer.Customer;
import Product.Interfaces.Shippable;

import java.util.ArrayList;

public class ECommerceSystem {
    // Handling the checkout (include shipment notice and checkout receipt)
    public static void checkOut(Customer customer, Cart cart) {

        // get normal Items
        ArrayList<CartItem> items = cart.getItems();

        // get Shippable items
        ArrayList<Shippable> shippableItems = cart.getShippableItems();

        // testing the ability of buying the items in the cart and buy it
        HandlePaymentOfPurchases(customer, cart);

        // Sending the shappable items to the SippingService
        if(!shippableItems.isEmpty()){
            ShippingService.shipProducts(shippableItems, cart);
        }

        // Printing the Receipt
        printReceipt(items);

        System.out.println("--------------------------------");

        double subtotal = cart.getSubTotal();
        double shippingFees = cart.getShippedPrice();
        double totalcost = cart.getTotalPrice();

        // Printing the Subtotal, Shipping Fees , and the total cost
        System.out.printf("Subtotal:\t\t%.0f%n", subtotal);
        System.out.printf("Shipping:\t\t%.0f%n", shippingFees);
        System.out.printf("Amount:\t\t\t%.0f%n", totalcost);
        System.out.printf("Remaining Balance:\t\t%.0f%n", customer.getBalance());

    }


    // printing every item information (name , price , amount)
    private static void printReceipt(ArrayList<CartItem> items) {

        System.out.println("** Checking receipt **");

        for(CartItem item : items) {
            String name = item.getProduct().getName();
            double price = item.getSubtotalPrice();
            int amount = item.getAmount();

            System.out.printf("%dx %s\t\t\t\t %.2f$%n",
                    amount,
                    name,
                    price
            );
        }

    }

    // Handling the Payment by (verifying the ability of Purchases & decrease customer balance and item stock)
    private static void HandlePaymentOfPurchases(Customer customer, Cart cart) {
        //Verify if the Customer can buy the items in the cart or not
        VerifyValidityOfPurchases(customer, cart);

        // withdrawing the needed amount of money from the customer balance
        customer.withdraw(cart.getTotalPrice());

        // decrease the quanity of the items after payment method
        for(CartItem item : cart.getItems()) {
            int currentQuantity = item.getProduct().getQuantity();
            item.getProduct().setQuantity(currentQuantity - item.getAmount());
        }

    }

    // Handling the potential errors of the Purchases process
    private static void VerifyValidityOfPurchases(Customer customer, Cart cart) {
        ArrayList<CartItem> items = cart.getItems();

        // Handling the Empty Cart error
        if (cart.isEmpty()) {
            throw new IllegalStateException("Can't checkout with empty cart");
        }

        // Handling if one Product is not available (out of stock or expired) error
        for(CartItem item : items) {
            if(!item.getProduct().isAvailableToOrder(item.getAmount())){
                throw new IllegalArgumentException("Product.Product: " + item.getProduct().getName()+ " is not available or expired");
            }
        }

        // Handling insufficient balance of the Customer error
        if(customer.getBalance() < cart.getTotalPrice()){
            throw new IllegalArgumentException("Customer.Customer doesn't have enough Balance");
        }
    }




}
