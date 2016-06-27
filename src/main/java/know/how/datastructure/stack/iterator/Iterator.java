package know.how.datastructure.stack.iterator;

/**
 * Created by pskurski on 6/27/2016.
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();

    void remove();
}
