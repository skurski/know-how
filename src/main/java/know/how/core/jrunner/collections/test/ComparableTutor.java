package know.how.core.jrunner.collections.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 *	1) Implement method Set<Animal> getAnimalsOrderedByNameSet()
 * 		and method Set<Animal> getAnimalsOrderedByNameSetDesc()
 */
public class ComparableTutor {
    String [] animals =
        {"Cow", "Goose", "Cat", "Dog", "Elephant",
        "Rabbit", "Snake", "Chicken", "Horse", "Human"};

    class Animal implements Comparable<Animal> {
        String name;
        public Animal(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
		@Override
		public int compareTo(Animal o) {
			return this.name.compareTo(o.name);
		}
    }

    /**
	 * Method should return a Set of Animal instances, alphabetically sorted
	 * Use TreeSet for that and implement Comparable interface in Animal class.
     */
    public Set<Animal> getAnimalsOrderedByNameSet() {
        Set<Animal> animalSet = new TreeSet<Animal>();
        for (String str: animals) {
        	animalSet.add(new Animal(str));
        }
        return animalSet;
    }

    /**
	 * Method should return a Set of Animal instances,
	 * ordered by the name in reverse order.
	 * Use TreeSet for that and pass a Comparator implementation as a parameter.
     *
     */
    public Set<Animal> getAnimalsOrderedByNameSetDesc() {
        Set<Animal> animalSet = new TreeSet<Animal>(new Comparator<Animal>() {
        	@Override
        	public int compare(Animal a1, Animal a2) {
        		char val1[] = a1.name.toCharArray();
        		char val2[] = a2.name.toCharArray();
                int len1 = val1.length;
                int len2 = val2.length;
                int lim = Math.min(len1, len2);

                for (int i=0; i<lim; i++) {
                    if (val1[i] != val2[i]) {
                        return val2[i] - val1[i];
                    }
                }
                return len2 - len1;
        	}
        });
        
        for (String str: animals) {
        	animalSet.add(new Animal(str));
        }
        return animalSet;
    }

    public String joinByCycle(Collection<?> c) {
        if (c==null) return "";
        StringBuilder builder = new StringBuilder();
        for (Object s: c) {
            builder.append(s);
            if (builder.length()>0) builder.append(", ");
        }
        return builder.toString();
    }

    @Test
    public void testCollections() {
        log("getAnimalsList: "+joinByCycle(Arrays.asList(animals)));

        log("getAnimalsOrderedByNameSet: "+joinByCycle(getAnimalsOrderedByNameSet()));
        log("getAnimalsOrderedByNameSetDesc: "+joinByCycle(getAnimalsOrderedByNameSetDesc()));
    }

    @Test
    public void getAnimalsOrderedByNameSet_default_returnsSortedSet() {
        Set<Animal> set = getAnimalsOrderedByNameSet();
        String join = joinByCycle(set);
        assertEquals("Cat, Chicken, Cow, Dog, Elephant, Goose, Horse, Human, Rabbit, Snake, ", join);
    }

    @Test
    public void getAnimalsOrderedByNameSetDesc_default_returnsSortedSet() {
        Set<Animal> set = getAnimalsOrderedByNameSetDesc();
        String join = joinByCycle(set);
        assertEquals("Snake, Rabbit, Human, Horse, Goose, Elephant, Dog, Cow, Chicken, Cat, ", join);
    }
    
	private void log(Object obj) {
		System.out.println(obj);
	}
}

