package know.how.complexpatterns.account;

/**
 * Factory for accounts
 * Design Pattern: Factory Method
 */
public class AccountFactory {

    private static int accountIdCounter;

    public static AbstractAccount createAccount(AbstractAccount.Type type) {
        if (type == AbstractAccount.Type.CHECKING) {
            return new CheckingAccount(accountIdCounter++, 0.0, 0.0, AbstractAccount.Type.CHECKING);
        }
        if (type == AbstractAccount.Type.SAVING) {
            return new SavingAccount(accountIdCounter++, 0.0, AbstractAccount.Type.SAVING);
        }
        return null;
    }

    public static AbstractAccount createAccountWithBalance(AbstractAccount.Type type, double balance) {
        if (type == AbstractAccount.Type.CHECKING) {
            return new CheckingAccount(accountIdCounter++, balance, 0.0, AbstractAccount.Type.CHECKING);
        }
        if (type == AbstractAccount.Type.SAVING) {
            return new SavingAccount(accountIdCounter++, balance, AbstractAccount.Type.SAVING);
        }
        return null;
    }
}
