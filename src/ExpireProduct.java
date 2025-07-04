import java.util.Date;

public class ExpireProduct extends Product{
    Date expireDate;
    public ExpireProduct(String name,int price, int quantity, Date expireDate) {
        super(name, price, quantity);
        this.expireDate = expireDate;
    }

    @Override
    public boolean isValidToHave(int order) {
        Date currentDate = new Date();
        return order <= this.quantity && expireDate.after(currentDate);
    }

    public Date getExpireDate() {
        return expireDate;
    }
}
