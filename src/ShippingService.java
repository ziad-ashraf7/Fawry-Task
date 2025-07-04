import java.awt.*;
import java.util.ArrayList;

public class ShippingService {
    public void shipProducts(ArrayList<Shippable> products, ArrayList<CartItem> items){
        int cost = 0;
        System.out.println("** Shipping notice **");
        double totalWeight = 0;
        for(Shippable product : products){
            int totalAmount = getAmountOfItem(product, items);

            double itemWeight = product.getWeight()*totalAmount;
            String meassure = "g";
            totalWeight += itemWeight;

            if((itemWeight%1000) != itemWeight){
                meassure = "kg";
                itemWeight = itemWeight/1000;
            }

            System.out.println(totalAmount+"x "+product.getName()+"               "+itemWeight+""+meassure);

        }
        if((totalWeight % 1000) == totalWeight){
            System.out.println("Total package weight  "+ totalWeight+"g");
        }else{
            System.out.println("Total package weight  "+ totalWeight/1000+"kg");
        }

        System.out.println();

    }

    private int getAmountOfItem(Shippable product, ArrayList<CartItem> items) {
        for(CartItem item : items){
            if(item.getProduct().equals(product)){
                return item.getAmount();
            }
        }
        return 0;
    }
}
