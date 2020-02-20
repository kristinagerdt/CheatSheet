package reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) {
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class clazz = obj.getClass();
        if (clazz == String.class) return (String) obj;
        if (clazz.isArray()) {
            StringBuilder result = new StringBuilder(clazz.getComponentType() + "[]{");
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) result.append(",");
                Object val = Array.get(obj, i);
                if (clazz.getComponentType().isPrimitive()) result.append(val);
                else result.append(toString(val));
            }
            return result + "}";
        }

        StringBuilder result = new StringBuilder(clazz.getName());
        // inspect the fields of this class and all superclasses
        do {
            result.append("[");
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // get the names and values of all fields
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (!result.toString().endsWith("[")) result.append(",");
                    result.append(field.getName()).append("=");
                    try {
                        Class type = field.getType();
                        Object o = field.get(obj);
                        if (type.isPrimitive()) result.append(o);
                        else result.append(toString(o));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            result.append("]");
            clazz = clazz.getSuperclass();
        }
        while (clazz != null);
        return result.toString();
    }
}