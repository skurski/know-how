package know.how.designpatterns.observer;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public abstract class Notifier<T> implements Serializable {

	private static final long serialVersionUID = -8616327045006117857L;
	private List<EventNotificationListener<T>> listeners = new LinkedList<>();

    public void registerListener(EventNotificationListener<T> listener){
        listeners.add(listener);
    }

    protected void notify(T obj){
        for (EventNotificationListener<T> listener: listeners)
            listener.onClientAdded(obj);
    }
}