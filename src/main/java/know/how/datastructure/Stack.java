package know.how.datastructure;


import java.util.concurrent.ConcurrentHashMap;

public final class Stack<E> implements Lifo<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public E pop() {
        if (first == null) {
            throw new NullPointerException("Stack is empty!");
        }

        Node<E> pop = last;
        last = last.prev;
        size--;

        return pop.elem;
    }

    @Override
    public void push(E elem) {
        if (elem == null)
            return;

        if (first == null) {
            first = new Node<>(elem, null);
            last = first;
        } else {
            Node<E> newNode = new Node<>(elem, last);
            last = newNode;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    @Override
    public void clean() {

    }

    @Override
    public int size() {
        return size;
    }

    public void iterate() {
        Node<E> temp = last;
        while (temp != null) {
            System.out.println(temp.elem);
            temp = temp.prev;
        }
    }

    private static class Node<E> {
        E elem;
        Node<E> prev;

        Node(E elem, Node<E> prev) {
            this.elem = elem;
            this.prev = prev;
        }
    }


    public static void main (String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(55);
        stack.push(198);
        stack.push(-532);
        stack.push(64564);

        stack.iterate();
        System.out.println("stack size: " + stack.size);

        System.out.println();
        System.out.println("stack pop: " + stack.pop());
        System.out.println("stack pop: " + stack.pop());
        System.out.println("stack pop: " + stack.pop());

        System.out.println();
        stack.iterate();
        System.out.println("stack size: " + stack.size);

//        System.out.println();
//        System.out.println("stack pop: " + stack.pop());

        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
     }
}
