package Services;

import Cart.Cart;
import Cart.CartItem;
import Product.Interfaces.Shippable;

import java.util.ArrayList;

public class ShippingService {
    public static void shipProducts(ArrayList<Shippable> products, Cart cart){


        System.out.println("** Shipping notice **");

        // getting the total Weight for the Shippable items from the cart
        double totalWeight = cart.getTotalShippedWeight();

        for(Shippable product : products){
            // Getting the total amount ordered for a product
            int totalAmount = getAmountOfItem(product, cart.getItems());

            double itemWeight = product.getWeight()*totalAmount;
            String meassure = "g";

            // in case the total weight is bigger than 1000g , make the meassure be "kg"
            if((itemWeight%1000) != itemWeight){
                meassure = "kg";
                itemWeight = itemWeight/1000;
            }


            System.out.printf("%dx %s\t\t\t\t %.2f%s%n",
                    totalAmount,
                    product.getName(),
                    itemWeight,
                    meassure
            );
        }

        // printing the Total weight for the shipped items
        if((totalWeight % 1000) == totalWeight){
            System.out.printf("\nTOTAL package weight %.1fg%n%n", totalWeight);
        }else{
            System.out.printf("\nTOTAL package weight %.1fkg%n%n", totalWeight/1000);
        }
    }

    private static int getAmountOfItem(Shippable product, ArrayList<CartItem> items) {
        for(CartItem item : items){
            if(item.getProduct().equals(product)){
                return item.getAmount();
            }
        }
        return 0;
    }
}
