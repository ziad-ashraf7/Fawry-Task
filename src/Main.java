import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ECommerceSystem ec = new ECommerceSystem();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date expirDate = cal.getTime();
        Product cheese = new ShippableExpirableProduct("Cheese", 10, 50, expirDate, 300);
        Product biscuits = new ExpireProduct("Bescuits", 50, 2, expirDate);
        Product Tv = new ShippableProduct("TV", 10, 10, 50);
        Product mobile = new NonExpireNonShippableProduct("Mobile", 100, 5);



        Customer customer = new Customer("ziad", 1000);
        Cart cart = new Cart();
        cart.add(biscuits, 1);
        cart.add(biscuits, 1);
        cart.add(mobile,1);
        cart.add(Tv, 1);




        ec.checkOut(customer , cart);
    }
}