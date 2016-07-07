package know.how.designpatterns.observer;

import java.io.Serializable;

public interface EventNotificationListener<T> extends Serializable {
    void onClientAdded(T client);
}