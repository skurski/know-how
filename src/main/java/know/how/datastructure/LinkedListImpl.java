package know.how.datastructure;

/**
 * Simple list implementation
 */
public class LinkedListImpl<E> {
    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

    public LinkedListImpl() {}

    public void add(E elem) {
        Node<E> node = last;
        System.out.println("last: " + last);
        Node<E> newNode = new Node<E>(elem,node,null);
        if (last == null)
            first = newNode;
        else
            last.next = newNode;

        last = newNode;
        size++;
    }

    public E get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException();
        Node<E> node = first;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public boolean remove(E elem) {
        Node<E> node = first;
        if (elem == null) {
            while (node != null) {
                if (node == null) {
                    //unlink
                    return true;
                }
                node = node.next;
            }
        } else {
            while (node != null) {
                if (node.item.equals(elem)) {
                    unlink(node);
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private void unlink(Node<E> node) {
        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;

        if (prevNode == null) {
            first = nextNode;
        } else {
            prevNode.next = nextNode;
            node.prev = null;
        }

        if (nextNode == null) {
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
            node.next = null;
        }

        node.item = null;
        size--;
    }

    public void print() {
        Node<E> node = first;
        for (int i=0; i<size; i++) {
            System.out.println("i: " + node.item);
            node = node.next;
        }
        System.out.println("Size: " + size);
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(E elem, Node<E> prev, Node<E> next) {
            item = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedListImpl<>();
        list.add(66);
        list.add(1);
        list.add(5);
        list.add(-23);
        list.add(45);
        list.print();

        System.out.println("get => " + list.get(4));
        System.out.println("get => " + list.get(2));
        System.out.println("get => " + list.get(0));
        System.out.println("get => " + list.get(1));

        System.out.println("remove 5: " + list.remove(5));
        System.out.println("remove 66: " + list.remove(66));

        list.print();
    }

}
