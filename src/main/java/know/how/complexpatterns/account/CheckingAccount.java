package know.how.complexpatterns.account;

/**
 * CheckingAccount
 */
public class CheckingAccount extends AbstractAccount {

    private double overdraft;

    public CheckingAccount(int id, double balance, double overdraft) {
        super(id, balance);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public String showAccount() {
        return "CheckingAccount{" +
                "id=" + getId() +
                ", balance=" + getBalance() +
                ", overdraft=" + getOverdraft() +
                '}';
    }
}
