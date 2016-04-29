package know.how.codingtasks;


/**
 * Fizz Buzz task
 *
 * @author Piotr Skurski
 */
public class FizzBuzz {

    public static void printFizzBuzz() {

        for (int i = 1; i < 101; i++) {
            String str = "";
            str += (i % 3 == 0) ? "Fizz" : "";
            str += (i % 5 == 0) ? "Buzz" : "";
            System.out.println(str.isEmpty() ? i : str);
        }
    }

    public static void main(String[] args) {
        printFizzBuzz();
    }
}
