package know.how.collection.testing;


import java.util.*;

public class SetTest {

    public static void main (String[] args) {

        Set<String> hashSet = new HashSet<>();
        hashSet.add("John");
        hashSet.add("Peter");
        hashSet.add("John");

        System.out.println(hashSet.toString());

        SortedSet<String> treeSet = new TreeSet<>();
        treeSet.add("John");
        treeSet.add("Peter");
        treeSet.add("John");

        Set<String> linkedSet = new LinkedHashSet<>();

        System.out.println(treeSet.toString());

        List<String> list = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        Queue<String> q = new LinkedList<>();
        Deque<String> dq = new LinkedList<>();

        Queue<String> stack = new ArrayDeque<>();
        Deque<String> stack2 = new ArrayDeque<>();

        Queue<String> heap = new PriorityQueue<>();


        Map<String,String> map = new HashMap<>();
        Map<String,String> linkedMap = new LinkedHashMap<>();
    }
}
