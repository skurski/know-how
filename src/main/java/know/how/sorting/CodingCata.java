package know.how.sorting;


import java.util.Arrays;

public class CodingCata {

    public static void insertionSort(int[] array) {
        for (int i=1; i<array.length; i++) {
            int move = array[i];
            int j = i;
            while (j > 0 && array[j-1] > move) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = move;
        }

        array = new int[]{9,8,1,2}; // array is an object and is passed by
                                    // copy of reference
    }

    public static void quickSort(int[] array, int head, int tail) {
        if (head >= tail)
            return;

        int pivot = array[head];
        System.out.println("pivot: " + pivot);
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

        quickSort(array,head,pivot);
        quickSort(array,pivot+1,tail);
    }

    public static String reverse(String str) {
        char[] array = str.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return new String(array);
    }

    public static void main (String[] args) {
        int[] arr = {1034,3,2,65,1,-45,34,1,2,3,99,543,54};
//        insertionSort(arr);
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        String test = "Oto jest string.";
        String reverse = reverse(test);
        System.out.println(reverse);
    }
}
