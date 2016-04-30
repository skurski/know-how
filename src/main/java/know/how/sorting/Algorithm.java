package know.how.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Simple sorting algorithms
 */
public class Algorithm {

    public static int[] bubbleSort(int[] array) {
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    //swap and set the flag
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    flag = true;
                }
            }
        }

        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int idMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[idMin]) {
                    idMin = j;
                }
            }
            //swap
            int temp = array[idMin];
            array[idMin] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > key) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
        }

        return array;
    }

    public static int[] countingSort(int[] array, int max) {
        int[] helper = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            helper[array[i]]++;
        }
        int id = 0;
        for (int i = 0; i < helper.length; i++) {
            while (helper[i] > 0) {
                array[id++] = i;
                helper[i]--;
            }
        }

        return array;
    }

    public static int[] sortWithQuickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int iStart, int iEnd) {
        if (iStart < iEnd) {
            int pivot = partition(array, iStart, iEnd);
            quickSort(array, iStart, pivot);
            quickSort(array, pivot + 1, iEnd);
        }
    }

    private static int partition(int[] array, int iStart, int iEnd) {
        int pivot = array[iStart];

        while (true) {
            while (array[iStart] < pivot) iStart++;
            while (array[iEnd] > pivot) iEnd--;

            if (iStart < iEnd) {
                int temp = array[iStart];
                array[iStart] = array[iEnd];
                array[iEnd] = temp;
                iStart++;
                iEnd--;
            } else {
                break;
            }
        }
        return iEnd;
    }

    public static void quickSortSimpler(int[] array, int head, int tail) {
        if (head >= tail)
            return;

        int pivot = array[head];
        int i = head;
        int j = tail;
        while (true) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;

            if (i >= j)
                break;

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        pivot = j;

        quickSortSimpler(array, head, pivot);
        quickSortSimpler(array, pivot + 1, tail);
    }

    public static void main(String[] args) {
        Arrays.sort(new Object[]{new Object(), new Object()});
        Collections.sort(new ArrayList<String>());
    }

}
