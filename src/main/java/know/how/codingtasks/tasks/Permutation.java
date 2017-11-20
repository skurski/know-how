package know.how.codingtasks.tasks;

import java.util.*;

/**
 * Count number of permutations for given set (collection).
 *
 * Additionally display all permutations for given set.
 */
public class Permutation {

    private List<String> nSet = new ArrayList<>();

    private int size = 0;

    public Permutation(List set) {
        nSet = set;
        size = nSet.size();
    }

    /**
     * Count the number of permutations, it is size factorial.
     *
     * @return  int number of permutations
     */
    public int count() {
        int res = size;
        for (int i=size-1; i>0; i--) {
            res *= i;
        }

        return res;
    }

    public Set<String> getAll() {
        Set<String> permutations = new HashSet<>();

        int index = 0;
        calculatePermutationsForNElement(index);

        int index = 0;
        String first = nSet.get(index);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(first);
        stringBuffer.append(nSet.get(index+1));
    }

    public static void main(String[] args ) {

        List<String> set = new ArrayList<>();
        set.add("a");
        set.add("b");
        set.add("c");

        Permutation permutation = new Permutation(set);
        int numberOfPermutations = permutation.count();

        System.out.println(numberOfPermutations);
    }
}
