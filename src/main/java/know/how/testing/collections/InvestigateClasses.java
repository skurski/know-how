package know.how.testing.collections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class InvestigateClasses {
    private java.util.Collection<Integer> col;

    private java.util.Set<String> set;
    private java.util.List<Double> list;
    private java.util.Map<Integer, String> map;

    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;

    public void initializeLists() {
        // ArrayList
        arrayList = new ArrayList<Integer>();
        arrayList.add(10);
        arrayList.add(8);
        arrayList.add(6);
        arrayList.get(0);

        int index = Collections.binarySearch(arrayList, 8);
        System.out.println(index);

        // LinkedListImpl
        linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.get(0);
        linkedList.remove(10);
        linkedList.remove(new Integer(30));
    }

    public static void main (String[] args) {
        InvestigateClasses cls = new InvestigateClasses();
        cls.initializeLists();
    }

}
