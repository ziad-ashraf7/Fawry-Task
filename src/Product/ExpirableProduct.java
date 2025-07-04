package Product;

import java.util.Date;

public class ExpirableProduct extends Product {
    Date expireDate;
    public ExpirableProduct(String name, int price, int quantity, Date expireDate) {
        super(name, price, quantity);
        this.expireDate = expireDate;
    }

    @Override
    public boolean isAvailableToOrder(int order) {
        Date currentDate = new Date();
        return order <= this.quantity && expireDate.after(currentDate);
    }

    public Date getExpireDate() {
        return expireDate;
    }
}
