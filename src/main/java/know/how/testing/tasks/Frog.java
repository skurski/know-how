package know.how.testing.tasks;

import java.util.ArrayList;

/*
	A frog only moves forward, but it can move in steps 1 inch long or 
	in jumps 2 inches long. A frog can cover the same distance using
	different combinations of steps and jumps.
	
	Write a function that calculates the number of different combinations 
	a frog can use to cover a given distance.
	
	For example, a distance of 3 inches can be covered in three ways:
	step-step-step, step-jump, and jump-step.
 */
public class Frog {

    public static int numberOfWays(int n) {
    	ArrayList<String> result = new ArrayList<String>();
    	
    	counting("", n, result);
    	
    	for (String str : result) {
    		System.out.println(str);
    	}
    	
    	if ("jogh" == "jogh") {
    		System.out.println("Hej");
    	}
    	return result.size();
    }
    
    /*
     * Naive algorithm
     */
    private static void counting(String prev, int n, ArrayList<String> result) {
    	if (n == 0) {
    		result.add(prev);
    	} else if (n > 0) {
    		counting(prev + " step", n-1, result);
    		counting(prev + " jump", n-2, result);
    	}
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(30));
        //10 => 89
        //20 => 10946
    }
}