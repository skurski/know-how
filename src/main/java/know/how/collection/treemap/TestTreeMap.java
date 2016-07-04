package know.how.collection.treemap;

import java.util.Comparator;
import java.util.Map;

/**
 * See how the TreeMap works inside
 * TreeMapImpl is a copy of java.util.TreeMap
 *
 * Conclusions:
 * => TreeMap can't take NULL keys (throws NullPointerException)
 * => TreeMap can take NULL value
 * => If tree is empty, element is put as root
 * => If we put ( V put(K key, V value) ) new pair with the key that already exists in TreeMap,
 *    the value will be override and previous value will be return, if key doesn't exist then null will be returned
 * => If tree is not empty, comparator (compare method) is used to compare keys, if no comparator exists then
 *    compareTo method of keys objects is used (key is cast to Comparable type) and new entry object is inserted as
 *    left or right child of the parent
 * => If no Comparator<K> or Comparable<K> then exception is thrown (ClassCastException)
 * => Constructor can take Comparator or Map object or SortedMap obj
 * => Entry obj that is created inside TreeMap contains:
 *    key, value, reference to parent, reference to left, reference to right, boolean color (black = true)
 * => TreeMap is balanced binary tree structure, red - black tree
 * => After insertion of new pair the fixAfterInsertion() method is executed to optimize the tree (entries are mark
 *    with color)
 */
public class TestTreeMap {

    public static void main(String[] args) {
        Map<Integer, String> testMap = new TreeMapImpl<Integer, String>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer i1, Integer i2) {
//                        if (i1.compareTo(i2) < 0)
//                            return 1;
//                        if (i1.compareTo(i2) > 0)
//                            return -1;
                        if (i1 < i2)
                            return 1;
                        if (i1 > i2)
                            return -1;
                        return 0;
                    }
                }
        );

        testMap.put(0, "Piotr Skurski");
        testMap.put(1, "Agnieszka Chylin");
        testMap.put(2, "Daniel Smith");
        testMap.put(2, "Hej ho");
        testMap.put(3, null);

        printMap(testMap);

        System.out.println("\n\n");
        Map<Person, String> personsMap = new TreeMapImpl<Person, String>();
        personsMap.put(new Person("Jan", 0), "first person");
        personsMap.put(new Person("Peter", 1), "second person");
        personsMap.put(new Person("Aga", -1), "third person");

        printMap(personsMap);
    }

    public static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.print("key => " + entry.getKey());
            System.out.println(", val => " + entry.getValue());
        }
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int pesel;

    Person(String name, int pesel) {
        this.name = name;
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        if (pesel < o.pesel)
            return -1;
        if (pesel > o.pesel)
            return 1;
        return 0;
    }
}


