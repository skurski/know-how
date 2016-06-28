package know.how.complexpatterns.observer;

/**
 * Event listener
 */
public interface EventListener<T> {

    void onAccountAdded(T account);
}
