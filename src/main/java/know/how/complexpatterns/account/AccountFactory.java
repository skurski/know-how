package know.how.complexpatterns.account;

import know.how.complexpatterns.decorator.AccountDecorator;

/**
 * Factory for accounts
 * Design Pattern: Factory Method
 */
public class AccountFactory {

    private static int accountIdCounter;

    public static AbstractAccount createAccount(AbstractAccount.Type type) {
        if (type == AbstractAccount.Type.CHECKING) {
            return new CheckingAccount.Builder(accountIdCounter++, 0.0, AbstractAccount.Type.CHECKING, 0.0).build();
        }
        if (type == AbstractAccount.Type.SAVING) {
            return new SavingAccount.Builder(accountIdCounter++, 0.0, AbstractAccount.Type.SAVING).build();
        }
        return null;
    }

    public static AbstractAccount createAccountWithBalance(AbstractAccount.Type type, double balance) {
        if (type == AbstractAccount.Type.CHECKING) {
            return new CheckingAccount.Builder(accountIdCounter++, balance, AbstractAccount.Type.CHECKING, 0.0).build();
        }
        if (type == AbstractAccount.Type.SAVING) {
            return new SavingAccount.Builder(accountIdCounter++, balance, AbstractAccount.Type.SAVING).build();
        }
        return null;
    }

    public static AbstractAccount createDecoratedAccount(AbstractAccount.Type type, double balance) {
        return new AccountDecorator.Builder(createAccountWithBalance(type, balance)).build();
    }
}
