package reflection.helper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ReflectionHelper {
    private ReflectionHelper() {
    }

    public static <T> T instance(Class<T> type, Object... args) {
        try {
            if (args.length == 0) {
                return type.getDeclaredConstructor().newInstance();
            } else {
                Class<?>[] classes = toClasses(args);
                return type.getDeclaredConstructor(classes).newInstance(args);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getFieldValue(Object object, String name) {
        Field field = null;
        boolean isAccessible = true;
        try {
            field = object.getClass().getDeclaredField(name);
            isAccessible = field.isAccessible();
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (field != null && !isAccessible) {
                field.setAccessible(false);
            }
        }
        return null;
    }

    private static Class<?>[] toClasses(Object[] args) {
        return Arrays
                .stream(args)
                .map(Object::getClass)
                .toArray(Class<?>[]::new);
    }

    public static void main(String[] args) {
        Person person = ReflectionHelper.instance(Person.class, "Alex", 25);
        System.out.println(person);
        System.out.println(ReflectionHelper.getFieldValue(person, "name"));
    }
}