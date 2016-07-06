package know.how.core.enums;


public enum Week implements Showable {
    MONDAY("Monday") {
        void test() {}
    }, FRIDAY("Friday") {
        void test() {}
    };

    private String name;

    Week(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Name: " + name);
    }

    abstract void test();
}
