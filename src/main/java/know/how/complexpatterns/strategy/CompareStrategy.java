package know.how.complexpatterns.strategy;

/**
 * Comparator for accounts
 * Strategy pattern
 */
public interface CompareStrategy<E> {

    int compare(E elem1, E elem2);
}
