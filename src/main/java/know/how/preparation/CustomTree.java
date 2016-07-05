package know.how.preparation;

/**
 * Create binary tree with add method and traverse through it in order.
 * Tree will store Integer type.
 */
public class CustomTree<E extends Comparable> {

    private Entry<E> root;

    public CustomTree() {}

    public void add(E element) {
        if (root == null) {
            root = new Entry<>(element, null);
            return;
        }

        Entry<E> tmp = root;
        Entry<E> parent = null;
        while (tmp != null) {
            parent = tmp;

            if (tmp.e.compareTo(element) < 0) {
                tmp = tmp.right;
            } else if (tmp.e.compareTo(element) > 0) {
                tmp = tmp.left;
            } else {
                return; // element already in the tree
            }
        }

        Entry<E> newEntry = new Entry<>(element, parent);
        if (parent.e.compareTo(element) < 0) {
            parent.right = newEntry;
        } else {
            parent.left = newEntry;
        }
    }

    private void iterateInOrder(Entry<E> root) {
        if (root == null) {
            return;
        }
        iterateInOrder(root.left);
        System.out.println(root.e);
        iterateInOrder(root.right);
    }

    public void print() {
        iterateInOrder(root);
    }

    private static class Entry<E> {
        E e;
        Entry<E> parent;
        Entry<E> left;
        Entry<E> right;

        public Entry(E e, Entry<E> parent) {
            this.e = e;
            this.parent = parent;
        }

        public void setLeft(Entry<E> left) {
            this.left = left;
        }

        public void setRight(Entry<E> right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        CustomTree<Integer> tree = new CustomTree<>();
        tree.add(12);
        tree.add(24);
        tree.add(15);
        tree.add(1);
        tree.add(5);

        tree.print();
    }
}
