package know.how.complexpatterns;

import know.how.complexpatterns.account.AbstractAccount;
import know.how.complexpatterns.observer.EventListener;
import know.how.complexpatterns.observer.Notifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Client can have multiple accounts.
 * Adding account to client is a trigger for email notification
 */
public class Client extends Notifier<AbstractAccount> {

    private List<AbstractAccount> accounts = new ArrayList<>();

    public Client(List<AbstractAccount> accounts) {
        this.accounts = accounts;
        addListener(new EmailNotificationListener());
    }

    public void addAccount(AbstractAccount account) {
        accounts.add(account);
        notifyListeners(account);
    }

    private static class EmailNotificationListener implements EventListener<AbstractAccount> {

        @Override
        public void onAccountAdded(AbstractAccount account) {
            System.out.println("Email confirmation, account was added: " + account.showAccount());
        }
    }
}
