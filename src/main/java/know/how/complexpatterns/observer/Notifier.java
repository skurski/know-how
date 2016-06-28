package know.how.complexpatterns.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Container for accounts listeners
 */
public abstract class Notifier<T> {

    private List<EventListener<T>> listeners = new LinkedList<>();

    public void addListener(EventListener<T> listener) {
        this.listeners.add(listener);
    }

    public void notifyListeners(T account) {
        for (EventListener<T> listener : listeners) {
            listener.onAccountAdded(account);
        }
    }
}
