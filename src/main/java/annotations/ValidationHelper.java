package annotations;

import annotations.annotations.Email;
import annotations.annotations.Max;
import annotations.annotations.Min;

import java.lang.reflect.Field;

public class ValidationHelper {

    public static boolean validateObject(Object object) {
        Class clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Email.class)) {
                if (!isValidEmail((String) getValue(field, object))) {
                    return false;
                }
            }
            if (field.isAnnotationPresent(Min.class)) {
                Min min = field.getAnnotation(Min.class);
                if ((int) getValue(field, object) < min.value()) {
                    return false;
                }
            }
            if (field.isAnnotationPresent(Max.class)) {
                Max max = field.getAnnotation(Max.class);
                if ((int) getValue(field, object) > max.value()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Object getValue(Field field, Object object) {
        boolean canAccess = field.canAccess(object);
        try {
            if (!canAccess) {
                field.setAccessible(true);
            }
            return field.get(object);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            if (!canAccess) {
                field.setAccessible(false);
            }
        }
    }

    static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        int eta = email.indexOf('@');
        if (eta <= 0 || email.indexOf('@', eta + 1) != -1) {
            return false;
        }

        int lastDot = email.lastIndexOf('.');
        return lastDot >= eta && lastDot < email.length() - 1;
    }
}
