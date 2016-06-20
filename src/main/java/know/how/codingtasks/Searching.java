package know.how.codingtasks;


/**
 * Created by psk on 20.06.16.
 */
public class Searching {

    public static int binarySearch(int[] array, int search) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int midValue = array[middle];

            if (midValue < search) {
                start = middle + 1;
            } else if (midValue > search) {
                end = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static void main (String[] args) {
        int[] array = {1,3,6,8,9,22,44,66,77,88};
        int index = Searching.binarySearch(array, 77);
        System.out.println("Find value at index: " + index);
    }
}
