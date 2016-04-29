package know.how.collection.treemap;

import java.util.Comparator;
import java.util.Map;

/**
 * See how the TreeMap works inside
 * TreeMapImpl is a copy of java.util.TreeMap
 * Only for educational purpose!
 *
 * Conclusions:
 * 1) TreeMap can't take null keys but value can be null
 * 2) If tree is empty, element is put as root
 * 3) If tree is not empty, comparator (compare method) is used to
 *    compare keys, if no comparator exists then compareTo method of keys objects
 *    is used and new entry object is inserted as left or right child of the parent
 * 4) If no Comparator<K> or Comparable<K> then exception is thrown
 * 5) Constructor can take Comparator or Map object or SortedMap obj
 * 6) Entry obj that is created inside TreeMap contains:
 *    key, value, parent, left, right, color (boolean - black or red)
 * 7) TreeMap is balanced binary tree structure, red - black tree
 *
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
        Map<Person,String> personsMap = new TreeMapImpl<Person,String>();
        personsMap.put(new Person("Jan", 0), "first person");
        personsMap.put(new Person("Peter", 1), "second person");
        personsMap.put(new Person("Aga", -1), "third person");

        printMap(personsMap);
    }

    public static void printMap(Map<?,?> map) {
        for (Map.Entry<?,?> entry: map.entrySet()) {
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


