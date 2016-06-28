package know.how.core.jrunner.reflection.test;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static java.lang.System.out;

public class ReflectionTutor {
    final static String introspectClass = "TestClass";

    @Test
    public void testReflection() {
        try {

//            Class<?> c = Class.forName(introspectClass);
            Class c = TestClass.class;
            out.format("Class:%n  %s%n%n", c.getCanonicalName());
            // TODO: load ExampleTestedClass at runtime by name

            // TODO: show all constructors (use method showConstructors())
            showConstructors(c);

            // TODO: list all methods, return types and arguments
            showMethods(c);

            // TODO: list all fields and types of the class
            showFields(c);

            // TODO: call the printIt() method
            Method method = c.getDeclaredMethod("printIt");
            method.invoke(c.newInstance());

            // TODO: call the printItString() method, pass a String param
            Method method2 = c.getDeclaredMethod("printItString", new Class[]{String.class});
            method2.invoke(c.newInstance(), new Object[]{"test 1 param"});

            // TODO: call the printItInt() method, pass a int param
            Method method3 = c.getDeclaredMethod("printItInt", new Class[]{int.class});
            method3.invoke(c.newInstance(), new Object[]{999});

            // TODO: call the setCounter() method, pass a int param
            Method method4 = c.getDeclaredMethod("setCounter", new Class[]{int.class});
            method4.invoke(c.newInstance(), new Object[]{666});

            // TODO: call the printCounter() method
            Method method5 = c.getDeclaredMethod("printCounter");
            method5.invoke(c.newInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showConstructors(Class clazz) {
        // list of constructors
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constr:clazz.getConstructors()) {
            StringBuilder sb = new StringBuilder();
            for (Class param: constr.getParameterTypes()) {
                if (sb.length()>0) sb.append(", ");
                sb.append(param.getSimpleName());
            }
            sb.insert(0, "constructor: "+constr.getName()+"(");
            sb.append(")");
            log(sb.toString());
        }
        log("SuperClass: "+clazz.getSuperclass().getSimpleName());
    }

    public void showMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method: methods) {
            StringBuilder sb = new StringBuilder();
            sb.append("Method name: ");
            sb.append(method.getName());
            sb.append(", return type: ");
            sb.append(method.getReturnType());
            sb.append(", params: ");
            for (Class param: method.getParameterTypes()) {
                sb.append(param.getSimpleName());
                sb.append(", ");
            }
            log(sb.toString());
        }
    }

    public void showFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            StringBuilder sb = new StringBuilder();
            sb.append("Field name: ");
            sb.append(field.getName());
            sb.append(", ");
            sb.append("class: ");
            sb.append(field.getType().getSimpleName());
            log(sb.toString());
        }
    }

    @Test
    public void testShowConstructors() {
        showConstructors(String.class);
    }

    public static void log(String str) {
        System.out.println(str);
    }

}