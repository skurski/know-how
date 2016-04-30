package know.how.collection.arraylist;

import java.util.List;

/**
 * See how the ArrayList works inside
 * ArrayListImpl is a copy of java.util.ArrayList
 * Only for educational purpose!
 * <p/>
 * Conclusions:
 * 1) ArrayList is array of Objects ( Object[] )
 * 2) Initial capacity is 10
 * 3) ArrayList use System.arrayCopy inside
 * 4) ArrayList implements List interface, extends AbstractList
 */
public class TestArrayList {

    public static void main(String[] args) {
        List<String> persons = new ArrayListImpl<String>();

        persons.add("Piotr");
        persons.add("Jarek");
        persons.add("Aga");
        persons.add("Aga");
        persons.add("Aga");
        persons.add("Aga");
        persons.add("Aga");
        persons.add("Aga");
        persons.add("Aga");
        persons.add("Aga");
        persons.add("Aga");
        persons.add("Aga");
        persons.add("Aga");
        persons.add("Aga");
        persons.add(1, "Nowy");
    }

}
