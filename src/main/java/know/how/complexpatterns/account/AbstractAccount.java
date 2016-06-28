package know.how.complexpatterns.account;

import know.how.complexpatterns.observer.Notifier;

/**
 * Abstract Account
 */
public abstract class AbstractAccount extends Notifier {

    private int id;

    private double balance;

    private Type type;

    public AbstractAccount(AbstractBuilder builder) {
        this.id = builder.id;
        this.balance = builder.balance;
        this.type = builder.type;
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

    public Type getType() {
        return type;
    }

    public static abstract class AbstractBuilder {
        private int id;
        private double balance;
        private Type type;
        // additional fields...

        public AbstractBuilder(int id, double balance, Type type) {
            this.id = id;
            this.balance = balance;
            this.type = type;
        }

        public abstract AbstractAccount build();
    }

    public enum Type {
        CHECKING, SAVING
    }
}
