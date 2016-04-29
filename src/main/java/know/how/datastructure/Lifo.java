package know.how.datastructure;


public interface Lifo<E> {

    E pop();

    void push(E elem);

    boolean isEmpty();

    void clean();

    int size();
}
