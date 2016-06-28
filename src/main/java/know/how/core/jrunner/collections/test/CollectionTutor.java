package know.how.core.jrunner.collections.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
* 1) Implement method joinByCycle(). Check the result.
* 		Implement methods getAnimalsList(), getAnimalsSet() and return its values.
* 		How the results differ?
* 		Implement method joinByIterator()
*/
public class CollectionTutor {
   String [] animals =
        {"Cow", "Goose", "Cat", "Dog", "Elephant",
       "Rabbit", "Snake", "Chicken", "Horse", "Human", "Cow"};

   /**
   * This method should return the ArrayListImpl with all the animals
   */
   public List<String> getAnimalsList() {
//        Arrays.asList(animals);
       List<String> animalsList = new ArrayList<String>();
       for (String animal: animals)
           animalsList.add(animal);
       return animalsList;
   }

   /**
   * The method must return a Set with all the animals
   */
   public Set<String> getAnimalsSet() {
       Set<String> animalsSet = new HashSet<String>();
       for (String animal: animals)
           animalsSet.add(animal);
       return animalsSet;
   }

   /**
   * Method should take a collection of strings
   * and return one string consisting of all collection elements,
   * separated by commas, using for cycle
   */
   public String joinByCycle(Collection<?> c) {
       StringBuilder sb = new StringBuilder();
       for (Object str: c)
           sb.append((String) str + ",");
       sb.deleteCharAt(sb.length()-1);
       return sb.toString();
   }

   /**
   * Method should take a collection of strings
   * and return one string consisting of all collection elements,
   * separated by commas, using iterator
   */
   public String joinByIterator(Collection<?> c) {
       StringBuilder sb = new StringBuilder();
       Iterator<?> iter = c.iterator();
       while (iter.hasNext())
           sb.append(iter.next() + ",");
       sb.deleteCharAt(sb.length()-1);
       return sb.toString();
   }

   @Test
   public void testCollections() {
       log("getAnimalsList: "+joinByCycle(Arrays.asList(animals)));

       log("getAnimalsList: "+joinByCycle(getAnimalsList()));
       log("getAnimalsSet: "+joinByCycle(getAnimalsSet()));

       log("getAnimalsList by iterator: "+joinByIterator(getAnimalsList()));
   }

   @Test
   public void getAnimalsListShouldReturnsListContainsAllAnimals() {
       List<String> list = getAnimalsList();
       assertTrue(list.containsAll(Arrays.asList(animals)));
   }

   @Test
   public void getAnimalsSetShouldReturnsSetContainsAllAnimals() {
       Set<String> set = getAnimalsSet();
       assertTrue(set.containsAll(Arrays.asList(animals)));
   }

   @Test
   public void joinByCycleShouldReturnsStringWithAllAnimalsJoined() {
       String result = joinByCycle(make123Collection());
       assertEquals("1,2,3", result);
   }

   @Test
   public void joinByIteratorShouldReturnsStringWithAllAnimalsJoined() {
       String result = joinByIterator(make123Collection());
       assertEquals("1,2,3", result);
   }

   private Collection<String> make123Collection() {
       Collection<String> collection = new LinkedHashSet<String>();
       collection.add("1");
       collection.add("2");
       collection.add("3");
       return collection;
   }

   private void log(Object obj) {
       System.out.println(obj);
   }
}


