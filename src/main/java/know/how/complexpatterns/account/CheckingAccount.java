package know.how.complexpatterns.account;

/**
 * CheckingAccount
 */
public class CheckingAccount extends AbstractAccount {

    private double overdraft;

    public CheckingAccount(Builder builder) {
        super(builder);
        this.overdraft = builder.overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public static class Builder extends AbstractBuilder {
        private double overdraft;

        public Builder(int id, double balance, Type type, double overdraft) {
            super(id, balance, type);
            this.overdraft = overdraft;
        }

        @Override
        public AbstractAccount build() {
            return new CheckingAccount(this);
        }
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
