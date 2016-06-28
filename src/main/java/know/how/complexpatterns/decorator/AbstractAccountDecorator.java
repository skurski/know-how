package know.how.complexpatterns.decorator;

import know.how.complexpatterns.account.AbstractAccount;

/**
 * Adds functionality to accounts
 * Decorator pattern
 */
public abstract class AbstractAccountDecorator extends AbstractAccount {

    private AbstractAccount abstractAccount;

    public AbstractAccountDecorator(AbstractBuilder builder) {
        super(builder);
    }

    @Override
    public String showAccount() {
        return abstractAccount.showAccount();
    }

    public void setAbstractAccount(AbstractAccount abstractAccount) {
        this.abstractAccount = abstractAccount;
    }

    public AbstractAccount getAbstractAccount() {
        return abstractAccount;
    }
}
