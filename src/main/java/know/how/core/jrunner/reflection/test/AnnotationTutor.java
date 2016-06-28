package know.how.core.jrunner.reflection.test;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class AnnotationTutor {
    final static String introspectClass = "TestClass";

    @Test
    public void testAnnotations() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
//        Class<?> cls = Class.forName("TestClass");
        Class cls = TestClass.class;
        Class noparams[] = {};
        Method method = cls.getDeclaredMethod("printIt", noparams);

        // show information about method annotated with MyAnnotation
        // print name value of the annotation
        MyAnnotation annotation =
                method.getAnnotation(MyAnnotation.class);
        boolean myAnnotation = method.isAnnotationPresent(MyAnnotation.class);
        log("my annotation name="+annotation.name());

        // TODO: show information about all annotated fields
        // print name and properties of the annotations
        Default defAnno = cls.getDeclaredField("name").getAnnotation(Default.class);
        log("default annotation name=" + defAnno.value());
    }

    @Test
    public void testDefaultField() throws IllegalAccessException {
        TestClass ex = new TestClass();
        String name = getFieldValue(ex,"name");
        assertEquals(name, "noname");
        ex.name = "my name";
        String name2 = getFieldValue(ex,"name");
        assertEquals(name2, "my name");
    }

    public String getFieldValue(Object obj, String fieldName) throws IllegalAccessException {
        // TODO: should return the value of field
        // or defValue, if field was annotated by @Default and field is not set
        Class clazz = obj.getClass();
        Field[] fields = clazz.getFields();
        for (Field field: fields) {
            field.setAccessible(true);
            Object value = field.get(obj);
            if (value != null) {
                return value.toString();
            }
            if (field.isAnnotationPresent(Default.class)) {
                Default defAnno = field.getAnnotation(Default.class);
                return defAnno.value();
            }
        }
        return null;
    }

    public static void log(String name) {
        System.out.println(name);
    }

}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String name() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@interface Default {
    String value() default "";
}

class TestClass {
    @Default("my text")
    private String text;
    @Default("noname")
    public String name;
    private int counter;


    public TestClass() {
    }

    public TestClass(String text, int counter) {
        super();
        this.text = text;
        this.counter = counter;
    }

    @MyAnnotation(name="print me!")
    public void printIt(){
        System.out.println("printIt() no param");
    }

    public void printItString(String temp){
        System.out.println("printIt() with param String : " + temp);
    }

    public void printItInt(int temp){
        System.out.println("printIt() with param int : " + temp);
    }

    public void setCounter(int counter){
        this.counter = counter;
        System.out.println("setCounter() set counter to : " + counter);
    }

    public void printCounter(){
        System.out.println("printCounter() : " + this.counter);
    }

}