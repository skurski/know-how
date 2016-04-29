package know.how.reflection;


import java.io.Serializable;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class InfoAboutClass {

    public static void main (String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        // 3 ways to get object of Class
        Class clazz = Class.forName("knowhow.reflection.Example");
//        Class clazz = knowhow.reflection.Example.class;
//        Class clazz = new Example().getClass();

        Object objInFly = clazz.newInstance();

        Class[] interfaces = clazz.getInterfaces();
        for (Class cls: interfaces) {
            System.out.println("Interface: " + cls.getName());
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            Object value = field.get(objInFly);
            TestAnnotation ann = field.getAnnotation(TestAnnotation.class);
            System.out.println("Field name: " + field.getName()
                            + ", value: " + value
                            + ", annotation: " + ann.value());

        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method: methods) {
            System.out.println("Method name: " + method.getName());

            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation: annotations) {
                System.out.println("Method annotation: "
                        + annotation.toString());
            }

            Class[] parameters = method.getParameterTypes();
            for (Class cls: parameters) {
                System.out.println("Method parameter: " + cls.getName());
            }

            //invoke method
            Object[] params = {new ArrayList<String>(), 10};
            method.invoke(objInFly, params);
        }
    }
}

class Example implements Serializable {
    @TestAnnotation
    private String text = "Text";
    @TestAnnotation (value="another")
    private int number = 10;

    public Example() {

    }

    @Deprecated
    public void run(List<String> list, int num) {
        System.out.println("Method run executed");
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface TestAnnotation {
    String value() default "initial";
}
