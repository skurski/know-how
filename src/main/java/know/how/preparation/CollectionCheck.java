package know.how.preparation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Just to go into java core collections libraries.
 */
public class CollectionCheck {

    public static void main(String[] args) {

        Map<Integer, String> treeMap = new TreeMap<>();
        Map<Integer, String> hashMap = new HashMap<>();

        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        Queue<String> priorityQueue = new PriorityQueue<>();

        Deque<String> stack = new ArrayDeque<>();

        Object obj = new Object();
    }
}
