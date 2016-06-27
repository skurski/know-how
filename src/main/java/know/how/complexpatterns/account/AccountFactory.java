package know.how.complexpatterns.account;

/**
 * Factory for accounts
 * Design Pattern: Factory Method
 */
public class AccountFactory {

    private static int accountIdCounter;

    public static AbstractAccount createAccount(AbstractAccount.Type type) {
        if (type == AbstractAccount.Type.CHECKING) {
            return new CheckingAccount(accountIdCounter++, 0.0, 0.0);
        }
        if (type == AbstractAccount.Type.SAVING) {
            return new SavingAccount(accountIdCounter++, 0.0);
        }
        return null;
    }
}
