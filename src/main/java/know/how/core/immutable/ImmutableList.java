package know.how.core.immutable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Example of how implement immutable list.
 * General rules:
 * => class should be final (all methods in final class are final by default)
 * => fields should be final
 * => fields should be private
 * => don't allow to modify object's state
 * => if provide setters for mutable components -> use copy
 */
public final class ImmutableList {

    private final String name;

    private final List<String> values = new ArrayList<>();

    {
        values.add("one");
        values.add("two");
        values.add("three");
    }

    public ImmutableList() {
        name = "Test";
    }

    public ImmutableList(final String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return new CopyOnWriteArrayList(values);
//        return new ArrayList<>(values);
    }

    public List<String> setValue(int index, String value) {
        List<String> copyList = new ArrayList<String>(values);
        copyList.set(index, value);
        return copyList;
    }
}
