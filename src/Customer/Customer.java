package Customer;

public class Customer {
    private double balance;
    private String name;
    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void pay(double amount) {
        if(this.balance < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }
}
