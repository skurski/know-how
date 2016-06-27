package know.how.datastructure.stack;

/**
 * Created by pskurski on 6/27/2016.
 */
public interface Lifo<E> {

    void push(E element);

    E pop();

    boolean isEmpty();

}
