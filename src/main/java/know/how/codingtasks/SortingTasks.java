package know.how.codingtasks;

import java.util.Arrays;

/**
 * Class that contains different sorting methods
 *
 * @author Piotr Skurski
 */
public class SortingTasks {

    /**
     * Sort array that contains only 0 or 1
     *
     * @param arr array of int that need to be sorted
     */
    public static void sort(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            while (arr[i] != 1) i++;
            while (arr[j] != 0) j--;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] array = {0,0,0,1,1,1,0,1,1,0,0,1,0,1,1,1};

        sort(array);

        System.out.println(Arrays.toString(array));
    }
}
