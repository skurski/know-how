package know.how.collection.linkedlist;

import java.util.List;

/**
 * See how the LinkedListImpl works inside
 * LinkedListImpl is a copy of java.util.LinkedListImpl
 * Only for educational purpose!
 *
 * Conclusions:
 * 1) LinkedListImpl is a double linked list structure
 * 2) LinkedListImpl has a pointer to first and last element
 * 3) Inside list we have Vertice<E> object which contains:
 *    Element<E>, next and prev pointer
 * 4) Constructor can take another collection
 * 5) Initial capacity is 0, list grow one element at a time
 * 6) Implements List and Deque interface, extends AbstractSequentialList
 *
 */
public class TestLinkedList {

    public static void main(String[] args) {
        List<String> persons = new LinkedListImpl<String>();

        persons.add("Peter");
        persons.add("Aga");

        System.out.println();
        printList(persons);
    }

    public static void printList(List<? extends Object> list) {
        for (Object obj: list) {
            System.out.println(obj);
        }
    }
}
