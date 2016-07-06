package knowhow.sorting;


import know.how.sorting.Algorithm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortingTest {
    int[] test;
    int[] correct;

    @Before
    public void setUp() {
        test = new int[]{3,5,99,55,23,34,987,1025,2,1,55,55};
        correct = new int[]{1,2,3,5,23,34,55,55,55,99,987,1025};
    }

    @Test
    public void insertionSortTest() {
        int[] res = Algorithm.insertionSort(test);
        System.out.println(Arrays.toString(res));
        Assert.assertArrayEquals(correct, res);
    }

    @Test
    public void bubbleSortTest() {
        int[] res = Algorithm.bubbleSort(test);
        System.out.println(Arrays.toString(res));
        Assert.assertArrayEquals(correct, res);
    }

    @Test
    public void selectionSortTest() {
        int[] res = Algorithm.selectionSort(test);
        System.out.println(Arrays.toString(res));
        Assert.assertArrayEquals(correct, res);
    }

    @Test
    public void countingSortTest() {
        int[] res = Algorithm.countingSort(test, 1025);
        System.out.println(Arrays.toString(res));
        Assert.assertArrayEquals(correct, res);
    }

    @Test
    public void quickSortTest() {
        Algorithm.quickSort(test,0, test.length - 1);
        System.out.println(Arrays.toString(test));
        Assert.assertArrayEquals(correct, test);
    }

    @Test
    public void mergeSortTest() {
        Algorithm.mergeSort(test,0, test.length - 1);
        System.out.println(Arrays.toString(test));
        Assert.assertArrayEquals(correct, test);
    }

}
