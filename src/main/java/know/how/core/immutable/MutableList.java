package know.how.core.immutable;

import java.util.ArrayList;
import java.util.List;

/**
 * Example of how mutable field can be easily modify by other threads if
 * we return original reference (instead of copy of object)
 */
public final class MutableList {

    private final String name;

    private final List<String> values = new ArrayList<>();

    {
        values.add("one");
        values.add("two");
        values.add("three");
    }

    public MutableList() {
        name = "Test";
    }

    public MutableList(final String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
//        return Collections.unmodifiableList(values);
    }
}

