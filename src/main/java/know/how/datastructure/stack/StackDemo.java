package know.how.datastructure.stack;

import know.how.datastructure.stack.iterator.Iterator;

/**
 * Created by pskurski on 6/27/2016.
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("First String");
        stack.push("Second String");
        stack.push(null);
        stack.push("Third String");

        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());

        Iterator<String> iterator = stack.getIterator();
        while (iterator.hasNext()) {
            System.out.println("value: " + iterator.next());
        }

        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());

        System.out.println("Stack is empty: " + stack.isEmpty());

        while (iterator.hasNext()) {
            System.out.println("Empty stack");
            System.out.println("value: " + iterator.next());
        }
    }
}
