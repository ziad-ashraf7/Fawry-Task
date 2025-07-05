import Cart.Cart;
import Customer.*;
import Product.*;
import Services.ECommerceSystem;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ECommerceSystem ec = new ECommerceSystem();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date expirDate = cal.getTime();

        // Listing some products with different types
        Product cheese = new ShippableExpirableProduct("Cheese", 1, 5, expirDate, 300);
        Product biscuits = new ExpirableProduct("Bescuits", 50, 1, expirDate);
        Product Tv = new ShippableProduct("TV", 10, 1, 100);
        Product scratchCard = new NonExpireNonShippableProduct("Mobile", 100, 5);



        Customer customer = new Customer("ziad", 1000);
        Cart cart = new Cart();
        cart.add(biscuits, 1);
        cart.add(Tv,1 );
        cart.add(cheese, 5);
        cart.add(scratchCard,5);



        ECommerceSystem.checkOut(customer , cart);
    }
}