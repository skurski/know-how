package know.how.complexpatterns.account;

/**
 * SavingAccount
 */
public class SavingAccount extends AbstractAccount {

    public SavingAccount(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbstractBuilder {

        public Builder(int id, double balance, Type type) {
            super(id, balance, type);
        }

        @Override
        public AbstractAccount build() {
            return new SavingAccount(this);
        }
    }


    @Override
    public String showAccount() {
        return "CheckingAccount{" +
                "id=" + getId() +
                ", balance=" + getBalance() +
                '}';
    }
}
