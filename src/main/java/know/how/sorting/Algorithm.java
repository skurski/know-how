package know.how.sorting;

import java.util.Arrays;

/**
 * Sorting Algorithms:
 * 1. Bubble Sort
 * 2. Selection Sort
 * 3. Insertion Sort
 * 4. Counting Sort
 * 5. Quick Sort
 * 6. Merge Sort
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

        if (i < high) {
            quickSort(array, i, high);
        }
        if (low < j) {
            quickSort(array, low, j);
        }
    }

    public static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle+1, high);
            mergeParts(array, low, middle, high);
        }
    }

    private static void mergeParts(int[] array, int low, int middle, int high) {
        int[] tempArr = new int[array.length];
        for (int i=0; i<=high; i++) {
            tempArr[i] = array[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (tempArr[i] <= tempArr[j]) {
                array[k] = tempArr[i];
                i++;
            } else {
                array[k] = tempArr[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = tempArr[i];
            k++;
            i++;
        }

//        while (j <= high) {
//            array[k] = tempArr[j];
//            k++;
//            j++;
//        }
    }

    public static void main(String[] args) {
        int[] array = {9,8,7,3,2,1};
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
