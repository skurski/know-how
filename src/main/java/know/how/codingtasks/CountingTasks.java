package know.how.codingtasks;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that contains different counting methods
 *
 * @author Piotr Skurski
 */
public class CountingTasks {

    /**
     * Count number of occurrences of every unique char in a string
     *
     * @param str String that needs to be sorted
     */
    public static void countCharInString(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            Integer val = map.get(chars[i]);
            val = (val != null) ? val : 0;
            map.put(chars[i], ++val);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        countCharInString(new String("Tto do it correctly."));
    }
}
