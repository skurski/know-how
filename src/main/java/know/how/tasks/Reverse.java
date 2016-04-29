package know.how.tasks;


public class Reverse {

    public static int[] halfArrayReverse(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println("while iteration: " + start);
        return arr;
    }

    public static int[] wholeArrayReverse(int[] arr) {
        int n = arr.length-1;
        int i;
        for (i=0; i<=n; i++) {
            int temp = arr[i];
            arr[i] = arr[n-i];
            arr[n-i] = temp;
        }
        System.out.println("for iteration: " + i);
        return arr;
    }

    public static String stringReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String rawStringReverse(String str) {
        char[] charArr = str.toCharArray();
        int start = 0;
        int end = charArr.length-1;
        while (start < end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
        return new String(charArr);
    }

}
