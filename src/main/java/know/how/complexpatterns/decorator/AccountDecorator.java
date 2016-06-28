package know.how.complexpatterns.decorator;

import know.how.complexpatterns.account.AbstractAccount;

/**
 * Created by pskurski on 6/28/2016.
 */
public class AccountDecorator extends AbstractAccountDecorator {

    public AccountDecorator(Builder builder) {
        super(builder);
        setAbstractAccount(builder.abstractAccount);
    }

    @Override
    public String showAccount() {
        return sendEmail() + getAbstractAccount().showAccount();
    }

    private String sendEmail() {
        return "Account decorator for: ";
    }

    public static class Builder extends AbstractBuilder {

        private AbstractAccount abstractAccount;

        public Builder(int id, double balance, Type type) {
            super(id, balance, type);
        }

        public Builder(AbstractAccount abstractAccount) {
            super(abstractAccount.getId(), abstractAccount.getBalance(), abstractAccount.getType());
            this.abstractAccount = abstractAccount;
        }

        @Override
        public AbstractAccount build() {
            return new AccountDecorator(this);
        }
    }

}
