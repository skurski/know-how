package know.how.complexpatterns.decorator;

import know.how.complexpatterns.account.AbstractAccount;

/**
 * Created by pskurski on 6/28/2016.
 */
public class AccountDecorator extends AbstractAccountDecorator {

    public AccountDecorator(AbstractAccount abstractAccount) {
        super(abstractAccount);
    }

    @Override
    public String showAccount() {
        return sendEmail() + getAbstractAccount().showAccount();
    }

    private String sendEmail() {
        return "Account decorator for: ";
    }

}
