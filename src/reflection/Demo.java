package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Person person = new Person("Alex", "Smith", 26, false);
        getFields(person);
        getPrivateField(person);

        getMethods(person);
        getPrivateMethod(person); // private printData

        getConstructors();
        Optional<Person> optionalPerson = createInstance();
        optionalPerson.ifPresent(Demo::getPrivateMethod); // private printData

        // it works only with a default constructor without parameters
        // createInstanceDefaultConstructor();

        System.out.println(new ObjectAnalyzer().toString(person));
    }

    private static void getFields(Person person) {
        Field[] declaredFields = person.getClass().getDeclaredFields();
        System.out.println("Declared fields:");
        Arrays
                .stream(declaredFields)
                .forEach(System.out::println);

        Field[] publicFields = person.getClass().getFields();
        System.out.println("\nPublic fields:");
        Arrays
                .stream(publicFields)
                .forEach(System.out::println);
    }

    private static void getPrivateField(Person person) {
        Field field = null;
        try {
            field = person.getClass().getDeclaredField("firstName");
            field.setAccessible(true); // set access, because field is private
            field.set(person, "Max"); // set value, because there isn't a setter
            String firstName = (String) field.get(person);
            System.out.println("\nPrivate field firstName=" + firstName);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (field != null && field.isAccessible()) {
                field.setAccessible(false);
            }
        }
    }

    private static void getMethods(Person person) {
        Method[] declaredMethods = person.getClass().getDeclaredMethods();
        System.out.println("\nDeclared methods:");
        Arrays
                .stream(declaredMethods)
                .forEach(System.out::println);

        Method[] publicMethods = person.getClass().getMethods();
        System.out.println("\nPublic methods:");
        Arrays
                .stream(publicMethods)
                .forEach(System.out::println);
    }

    private static void getPrivateMethod(Person person) {
        Method method = null;
        try {
            method = person.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            System.out.println("\nMethod printData()");
            method.invoke(person);
            // Method sqrt = Math.class.getMethod("sqrt", double.class);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if (method != null && method.isAccessible()) {
                method.setAccessible(false);
            }
        }
    }

    private static void getConstructors() {
        System.out.println();
        try {
            Class clazz = Class.forName(Person.class.getName());
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println("Constructor " + constructor.getName() + ":");
                Class[] parameterTypes = constructor.getParameterTypes();
                for (Class parameterType : parameterTypes) {
                    System.out.println(parameterType.getName());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Optional<Person> createInstance() {
        try {
            Class clazz = Class.forName(Person.class.getName());
            Class[] parameters = {String.class, String.class, boolean.class};
            Person person = (Person) clazz.getConstructor(parameters).newInstance("Anna", "Smith", true);
            return Optional.of(person);
        } catch (ClassNotFoundException | InstantiationException |
                InvocationTargetException | NoSuchMethodException |
                IllegalAccessException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private static Optional<Person> createInstanceDefaultConstructor() {
        // it works only with a default constructor without parameters
        try {
            Class clazz = Class.forName(Person.class.getName());
            Person person = (Person) clazz.newInstance();
            return Optional.of(person);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}