package know.how.core.classes.interfaces;

/**
 * We can create class inside interface and other interfaces.
 * Classes nested inside interface are static classes by default (?).
 */
interface InterfaceTest {

    interface AnotherInterface {
        int y = 20;
    }

    class Some {
        private int x = 10;

        int getX() {
            return x;
        }
    }
}