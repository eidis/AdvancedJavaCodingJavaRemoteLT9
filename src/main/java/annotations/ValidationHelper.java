package annotations;

import annotations.annotations.Email;

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
