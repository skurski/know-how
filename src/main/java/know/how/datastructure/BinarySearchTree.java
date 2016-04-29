package know.how.datastructure;

/**
 * Simple binary search tree implementation
 */
public class BinarySearchTree<E> {
    private Node<E> root;
    private int size = 0;

    public BinarySearchTree() {}

    public void add(E elem) {
        if (root == null) {
            root = new Node<E>(elem,null,null,null);
            size++;
            return;
        }

        Node<E> parent;
        Node<E> tmp = root;
        int cmp;
        do {
            parent = tmp;
            cmp = ((Comparable<E>) elem).compareTo(tmp.item);
            if (cmp < 0) {
                tmp = tmp.left;
            } else if (cmp > 0) {
                tmp = tmp.right;
            } else {
                //element already exists, do nothing
                return;
            }
        } while (tmp != null);

        Node<E> newNode = new Node<E>(elem,parent,null,null);
        if (cmp < 0) {
            parent.left = newNode;
        }
        else {
            parent.right = newNode;
        }

        size++;
    }

    public void remove(E elem) {
        if (root == null || elem == null)
            return;

//        Vertex<E> toRemove = findNode(elem);

        Node<E> tmp = root;

        while (tmp != null) {
            int cmp = ((Comparable<E>) elem).compareTo(tmp.item);
            if (cmp < 0) {
                tmp = tmp.left;
            } else if (cmp > 0) {
                tmp = tmp.right;
            } else {
                break;
            }
        }


//        if (toRemove == root) {
//            if (root.left == null && root.right == null) {
//                root.item = null;
//                root = null;
//                size--;
//                return true;
//            }
//            if (root.left != null && root.right == null) {
//                root = root.left;
//                root.parent = null;
//                size--;
//                return true;
//            }
//            if (root.right != null && root.left == null) {
//                root = root.right;
//                root.parent = null;
//                size--;
//                return true;
//            }
//        }
//
//        if (toRemove.left != null && toRemove.right != null) {
//            Vertex<E> successor = toRemove.left;
//
//            if (toRemove != root) {
//                toRemove.parent.left = successor;
//                successor.parent = toRemove.parent;
//            } else {
//                toRemove.left.parent = null;
//                root = toRemove.left;
//            }
//
//            while (successor.right != null) {
//                successor = successor.right;
//            }
//            successor.right = toRemove.right;
//
//            toRemove.item = null;
//            size--;
//            return true;
//        } else if (toRemove.left != null && toRemove.right == null) {
//            toRemove.left.parent = toRemove.parent;
//            toRemove.parent.right = toRemove.left;
//            toRemove.item = null;
//            size--;
//            return true;
//        } else if (toRemove.left == null && toRemove.right != null) {
//            toRemove.right.parent = toRemove.parent;
//            toRemove.parent.left = toRemove.right;
//            toRemove.item = null;
//            size--;
//            return true;
//        } else if (toRemove.left == null && toRemove.right == null) {
//            if (toRemove.parent.left == toRemove) {
//                toRemove.parent.left = null;
//            } else {
//                toRemove.parent.right = null;
//            }
//            toRemove.item = null;
//            size--;
//            return true;
//        }



        if (tmp.left == null) {
            tmp.parent = tmp.right;
            System.out.println("a");
        } else if (tmp.right == null) {
            tmp.parent = tmp.left;
            System.out.println("b");

        } else {
            Node<E> successor = tmp.left;
            System.out.println("c");


            if (tmp != root) {
                tmp.parent.left = successor;
                successor.parent = tmp.parent;
            } else {
                tmp.left.parent = null;
                root = tmp.left;
            }

            while (successor.right != null) {
                successor = successor.right;
            }
            successor.right = tmp.right;
        }

        tmp.item = null;
        size--;
    }

    private Node<E> findNode(E elem) {
        Node<E> tmp = root;

        while (tmp != null) {
            int cmp = ((Comparable<E>) elem).compareTo(tmp.item);
            if (cmp < 0) {
                tmp = tmp.left;
            } else if (cmp > 0) {
                tmp = tmp.right;
            } else {
                break;
            }
        }
        return tmp;
    }

    private static class Node<E> {
        E item;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        Node(E elem,Node<E> parent,Node<E> left,Node<E> right) {
            item = elem;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    public void printInOrder() {
        System.out.println("In order traversal: ");
        traverseInOrder(root);
        System.out.println("tree size: " + size);
    }

    public void printPreOrder() {
        System.out.println("Pre order traversal: ");
        traversePreOrder(root);
        System.out.println("tree size: " + size);
    }

    public void printPostOrder() {
        System.out.println("Post order traversal: ");
        traversePostOrder(root);
        System.out.println("tree size: " + size);
    }

    private void traverseInOrder(Node<E> node) {
        if (node == null)
            return;
        traverseInOrder(node.left);
        System.out.print(node.item + ", ");
        traverseInOrder(node.right);
    }

    private void traversePreOrder(Node<E> node) {
        if (node == null)
            return;
        System.out.print(node.item + ", ");
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    private void traversePostOrder(Node<E> node) {
        if (node == null)
            return;
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.print(node.item + ", ");
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(12);
        tree.add(2);
        tree.add(8);
        tree.add(16);
        tree.add(-22);
        tree.add(3);
        tree.add(13);
        tree.add(55);
        tree.add(1);

//        tree.remove(5);
        tree.remove(10);
        tree.remove(8);

        tree.printInOrder();
        System.out.println();
        tree.printPreOrder();
        System.out.println();
        tree.printPostOrder();
    }
}
