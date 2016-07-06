package know.how.core.tasks;

/*
	Write a function that, given a list and a target sum, 
	returns zero-based indices of any two distinct elements 
	whose sum is equal to the target sum. If there are 
	no such elements, the function should return null.
	
	For example, findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12) 
	should return any of the following tuples of indices:
	
	1, 4 (3 + 9 = 12)
	2, 3 (5 + 7 = 12)
	3, 2 (7 + 5 = 12)
	4, 1 (9 + 3 = 12)
 */

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
    	int[] indices = new int[2];
    	
    	for (int i=0; i<list.length; i++) {
    		for (int j=0; j<list.length; j++) {
    			if (list[i] + list[j] == sum) {
    				indices[0] = i < j ? i : j;
    				indices[1] = i < j ? j : i;

    				return indices;
    			}
    		}
    	}
    	
    	return null;
    }
    
    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
}
