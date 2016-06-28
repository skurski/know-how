package know.how.complexpatterns;

import know.how.complexpatterns.account.AbstractAccount;
import know.how.complexpatterns.account.AccountFactory;
import know.how.complexpatterns.account.AccountRepository;
import know.how.complexpatterns.iterator.Iterator;
import know.how.complexpatterns.strategy.CompareStrategy;

/**
 * Demo Application that illustrate usage of various design patterns
 *
 * List of used design patterns:
 * 1) Factory Method -> for creating accounts
 * 2) Iterator -> custom iterator to iterate through accounts repository
 * 3) Decorator -> to add functionality to accounts
 * 4) Strategy -> for comparing accounts and sort accounts collection in repository
 * 5) Observer -> trigger sending email where new account is created
 * 6) Builder -> for building account object (it contain multiple constructor parameters)
 */
public class AppDemo {

    public static void main (String[] args) {

        AccountRepository repository = new AccountRepository(
                new CompareStrategy<AbstractAccount>() {
                    @Override
                    public int compare(AbstractAccount elem1, AbstractAccount elem2) {
                        if (elem1.getBalance() < elem2.getBalance()) {
                            return -1;
                        } else if (elem1.getBalance() > elem2.getBalance()) {
                            return 1;
                        }
                        return 0;
                    }
                }
        );

        Iterator<AbstractAccount> iterator = repository.getIterator();

        while (iterator.hasNext()) {
            System.out.println("Account specs: " + iterator.next().showAccount());
        }

        repository.addAccount(
                AccountFactory.createAccountWithBalance(AbstractAccount.Type.CHECKING, 44.34)
        );
        repository.addAccount(
                AccountFactory.createAccount(AbstractAccount.Type.SAVING)
        );
        repository.addAccount(
                AccountFactory.createDecoratedAccount(AbstractAccount.Type.SAVING, 1234.23)
        );
        repository.addAccount(
                AccountFactory.createAccountWithBalance(AbstractAccount.Type.CHECKING, 555.34)
        );
        repository.addAccount(
                AccountFactory.createAccountWithBalance(AbstractAccount.Type.CHECKING, 999.00)
        );

        System.out.println("AccountRepo size: " + repository.size());

        while (iterator.hasNext()) {
            System.out.println("Account specs: " + iterator.next().showAccount());
        }

        /* -------------- client ------------------- */
        System.out.println("------------------- listener -------------------------------");
        Client client = new Client(repository.getAccounts());
        client.addAccount(
                AccountFactory.createAccountWithBalance(AbstractAccount.Type.SAVING, 9876.5432)
        );

    }
}