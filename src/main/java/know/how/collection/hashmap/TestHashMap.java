package know.how.collection.hashmap;

import java.util.Map;

/**
 * Test how HashMap works inside
 * HashMapImpl is a copy of java.util.HashMap
 * Only for educational purpose!
 * <p/>
 * Conclusions:
 * 1) HashMap can take null keys and null values
 * 2) The object with the same key will be overridden
 * 3) Key object have to implement equals() and hashCode()
 * 4) Based on hash code of the key the bucket index of hash table is calculated
 * 5) Object inside HashMap is Entry object (Map.Entry)
 * 6) Hash table inside HashMap is array of Entry<K,V>
 * 7) Entry obj has: key, value, hash, next (pointer to next Entry obj)
 * 8) If keys has the same hash code they are inserted into the same bucket
 * and creates single linked list, new element is inserted at the
 * beginning of the list
 * 9) HashMap constructors can take initial capacity and load factor
 * 10) Default initial capacity is 16
 * 11) Default load factor is 0.75
 * 12) Threshold (capacity * loadFactor) is the size at which to resize
 * (this is the size of an array, not numbers of elements in HashMap)
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map<Person, String> personsMap = new HashMapImpl<Person, String>();

        personsMap.put(new Person("A", "0"), "Piotr Skurski");
        personsMap.put(new Person("B", "1"), "John Tester");
        personsMap.put(new Person("C", "1"), "John Tester");
        personsMap.put(new Person("D", "1"), "John Tester");
        personsMap.put(new Person("E", "1"), "John Tester");
        personsMap.put(new Person("F", "1"), "John Tester");
        personsMap.put(new Person("G", "1"), "John Tester");
        personsMap.put(new Person("H", "1"), "John Tester");
        personsMap.put(new Person("I", "1"), "John Tester");
        personsMap.put(new Person("M", "1"), "John Tester");
        personsMap.put(new Person("N", "1"), "John Tester");
        personsMap.put(new Person("Z", "1"), "John Tester");
        personsMap.put(new Person("Q", "1"), "John Tester");
        personsMap.put(new Person("ABC", "1"), "John Tester");
        personsMap.put(new Person("trewt", "1"), "John Tester");
        personsMap.put(new Person("nfgd", "1"), "John Tester");
    }
}

class Person {
    private String name;
    private String pesel;

    Person(String name, String pesel) {
        this.name = name;
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (hashCode() != o.hashCode()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        return pesel.equals(person.pesel);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + pesel.hashCode();
        System.out.println("person hashCode: " + result);
        return result;

        // see how elements are stored in one bucket using linked list
//        return 3;
    }
}
