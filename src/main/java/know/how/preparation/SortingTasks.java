package know.how.preparation;

import java.util.Arrays;

/**
 * Practise sorting tasks.
 */
public class SortingTasks {

    public static void quickSort(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(array, low, j);
        }
        if (i < high) {
            quickSort(array, i, high);
        }
    }

    public static void main(String[] args) {

        int[] array = {1,4,7,5,34,34,7,4,2,5,0,7,4,-43,65,-34};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
