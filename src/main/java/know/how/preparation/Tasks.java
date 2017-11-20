package know.how.preparation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Exercises before interview
 */
public class Tasks {

    public static boolean checkIfPalindrom(final String text) {
        char[] strArr = text.toCharArray();

        int i = 0;
        int j = strArr.length - 1;
        while (i < j) {
            char temp = strArr[j];
            strArr[j] = strArr[i];
            strArr[i] = temp;
            i++;
            j--;
        }

//        return text.equalsIgnoreCase(new String(strArr));

        for (int x=0; x<strArr.length; x++) {
            if (Character.toLowerCase(text.charAt(x)) != Character.toLowerCase(strArr[x])) {
                return false;
            }
        }

        return true;
    }

    public static void findNumberOfOccurenceInString(String text) {
        Map<Character, Integer> occurences = new HashMap<>();

        for (int i=0; i<text.length(); i++) {
            Integer count = occurences.get(text.charAt(i));
            count = (count == null) ? new Integer(1) : ++count;
            occurences.put(text.charAt(i), count);
        }

        for (Map.Entry<Character, Integer> entry : occurences.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public static void swapIntWithoutTempVar() {
        int x = 1;
        int y = 3;
        System.out.println("Before swapping => x: " +x+ ", y: " + y);

        // using temp variable
//        int temp = x;
//        x = y;
//        y = temp;

        // using arithmetic operator (addition)
        x = x + y; // x=4
        y = x - y; // y=1
        x = x - y; // x=3
        System.out.println("After swapping with arithmetic => x: " + x + ", y: " + y);

        // using bitwise operator (XOR)
        // x = 3 => 0010
        // y = 1 => 0001
        x = x ^ y; // 0011
        y = x ^ y; // 0010
        x = x ^ y; // 0001
        System.out.println("After swapping with XOR => x: " + x + ", y: " + y);

        // using division and multiplication
        // x = 1
        // y = 3
        x = x * y;
        y = x / y;
        x = x / y;
        System.out.println("After swapping with * and / => x: " + x + ", y: " + y);
    }

    public static void sortArrayWithZeroAndOne(int[] array) {
        // start: 0 1 1 0 1 1 1 0 0 0 1 1
        // sorted: 0 0 0 0 0 1 1 1 1 1 1 1
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (array[i] == 0) i++;
            while (array[j] == 1) j--;

            if (i < j) {
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }
        }

        System.out.println(Arrays.toString(array));
    }

    // binary search implementation
    public static int findIndexOfNumberInArray(int[] array, int value) {
        int low = 0;
        int high = array.length -1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (array[middle] < value) {
                low = middle + 1;
            } else if (array[middle] > value) {
                high = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println("Tesset is palidrom: " + checkIfPalindrom("Tesset"));

        findNumberOfOccurenceInString("Some string with something!");

        sortArrayWithZeroAndOne(new int[] {1,1,0,0,1,0,1,0,1,1,0});

        System.out.println("Number is at index: " +
                findIndexOfNumberInArray(new int[] {2,4,6,8,23,43,222,555,999, 3425,4567,123456}, 999));

        swapIntWithoutTempVar();
    }
}
