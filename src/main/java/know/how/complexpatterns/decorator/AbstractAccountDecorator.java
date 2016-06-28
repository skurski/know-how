package know.how.complexpatterns.decorator;

import know.how.complexpatterns.account.AbstractAccount;

/**
 * Adds functionality to accounts
 * Decorator pattern
 */
public abstract class AbstractAccountDecorator extends AbstractAccount {

    private AbstractAccount abstractAccount;

    public AbstractAccountDecorator(AbstractAccount abstractAccount) {
        super(abstractAccount.getId(), abstractAccount.getBalance(), abstractAccount.getType());
        this.abstractAccount = abstractAccount;
    }

    @Override
    public String showAccount() {
        return abstractAccount.showAccount();
    }

    public AbstractAccount getAbstractAccount() {
        return abstractAccount;
    }
}
