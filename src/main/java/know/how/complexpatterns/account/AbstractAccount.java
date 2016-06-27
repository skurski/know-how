package know.how.complexpatterns.account;

/**
 * Abstract Account
 */
public abstract class AbstractAccount {

    private int id;

    private double balance;

    public AbstractAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract String showAccount();

    public enum Type {
        CHECKING, SAVING
    }
}
