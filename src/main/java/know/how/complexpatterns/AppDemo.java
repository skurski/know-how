package know.how.complexpatterns;

import know.how.complexpatterns.account.AbstractAccount;
import know.how.complexpatterns.account.AccountFactory;
import know.how.complexpatterns.account.AccountRepository;
import know.how.complexpatterns.iterator.Iterator;
import know.how.complexpatterns.strategy.CompareStrategy;

/**
 * Demo Application that illustrate usage of various design patterns
 *
 * List of design patterns:
 * 1) Factory Method
 * 2) Iterator
 * 3) Decorator
 * 4) Strategy
 */
public class AppDemo {

    public static void main (String[] args) {
        AccountRepository repository = new AccountRepository(
                new CompareStrategy<AbstractAccount>() {
                    @Override
                    public int compare(AbstractAccount elem1, AbstractAccount elem2) {
                        // todo: implement
                        return 0;
                    }
                }
        );
        Iterator<AbstractAccount> iterator = repository.getIterator();

        while (iterator.hasNext()) {
            System.out.println("Account specs: " + iterator.next().showAccount());
        }

        repository.addAccount(
                AccountFactory.createAccount(AbstractAccount.Type.CHECKING)
        );
        repository.addAccount(
                AccountFactory.createAccount(AbstractAccount.Type.SAVING)
        );
        repository.addAccount(
                AccountFactory.createAccount(AbstractAccount.Type.SAVING)
        );
        repository.addAccount(
                AccountFactory.createAccount(AbstractAccount.Type.CHECKING)
        );
        repository.addAccount(
                AccountFactory.createAccount(AbstractAccount.Type.CHECKING)
        );

        System.out.println("AccountRepo size: " + repository.size());

        while (iterator.hasNext()) {
            System.out.println("Account specs: " + iterator.next().showAccount());
        }
    }
}