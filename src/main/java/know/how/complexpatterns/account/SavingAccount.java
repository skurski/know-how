package know.how.complexpatterns.account;

/**
 * SavingAccount
 */
public class SavingAccount extends AbstractAccount {

    public SavingAccount(int id, double balance) {
        super(id, balance);
    }


    @Override
    public String showAccount() {
        return "CheckingAccount{" +
                "id=" + getId() +
                ", balance=" + getBalance() +
                '}';
    }
}
