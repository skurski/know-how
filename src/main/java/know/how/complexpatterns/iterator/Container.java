package know.how.complexpatterns.iterator;

/**
 * Container that return iterator
 */
public interface Container<E> {

    Iterator<E> getIterator();
}
