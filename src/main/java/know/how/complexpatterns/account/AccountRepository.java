package know.how.complexpatterns.account;

import know.how.complexpatterns.iterator.Container;
import know.how.complexpatterns.iterator.Iterator;
import know.how.complexpatterns.strategy.CompareStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Account Collection with Iterator
 */
public class AccountRepository implements Container<AbstractAccount> {

    private List<AbstractAccount> accounts = new ArrayList<>();

    private CompareStrategy<AbstractAccount> compareStrategy;

    public AccountRepository(CompareStrategy<AbstractAccount> compareStrategy) {
        this.compareStrategy = compareStrategy;
    }

    public void addAccount(final AbstractAccount account) {
        java.util.Iterator<AbstractAccount> iter = accounts.iterator();
        int i = 0;
        while (iter.hasNext() && compareStrategy.compare(iter.next(), account) <= 0) {
            i++;
        }
        accounts.add(i, account);
    }

    public int size() {
        return accounts.size();
    }

    public List<AbstractAccount> getAccounts() {
        return accounts;
    }

    @Override
    public Iterator<AbstractAccount> getIterator() {
        return new AccountIterator();
    }

    private class AccountIterator implements Iterator<AbstractAccount> {
        int currentAccountId;

        @Override
        public boolean hasNext() {
            if (accounts.isEmpty()) {
                return false;
            }

            if (currentAccountId > accounts.size()-1) {
                return false;
            }

            return true;
        }

        @Override
        public AbstractAccount next() {
            if (!hasNext()) {
                return null;
            }

            return accounts.get(currentAccountId++);
        }
    }
}
