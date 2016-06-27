package know.how.datastructure.stack;

import know.how.datastructure.stack.iterator.Container;
import know.how.datastructure.stack.iterator.Iterator;

/**
 * Implementation of Stack data structure and Iterator design pattern
 * Accept null values
 */
public class Stack<E> implements Lifo<E>, Container<E> {

    private Node<E> top;
    private int size;

    @Override
    public void push(E element) {
//        if (element == null) {
//            throw new NullPointerException("You try to put null on stack!");
//        }

        Node<E> node = new Node<>(element, top);
        top = node;
        size++;
    }

    @Override
    public E pop() {
        if (top == null) {
            throw new NullPointerException("Stack is empty!");
        }

        Node<E> topNode = top;
        top = top.prev;
        size--;

        return topNode.value;
    }

    @Override
    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> getIterator() {
        return new StackIterator<E>();
    }

    private static class Node<V> {
        V value;
        Node prev;

        public Node(V value, Node prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    private class StackIterator<E> implements Iterator<E> {
        Node<E> pointer = (Node<E>) top;

        @Override
        public boolean hasNext() {
            if (pointer != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E next() {
            if (pointer != null) {
                Node<E> oldTop = (Node<E>) pointer;
                pointer = pointer.prev;
                return oldTop.value;
            }
            return null;
        }

        @Override
        public void remove() {
            if (pointer != null) {
                pointer = pointer.prev;
            }
        }
    }

    public int size() {
        return size;
    }
}
