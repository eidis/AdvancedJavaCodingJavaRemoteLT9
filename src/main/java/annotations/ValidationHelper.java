package annotations;

import annotations.annotations.Email;
import annotations.annotations.Max;
import annotations.annotations.Min;
import annotations.annotations.Password;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class ValidationHelper {

    private static Pattern LOWER_CASE_PATTERN = Pattern.compile("[a-z]");
    private static Pattern UPPER_CASE_PATTERN = Pattern.compile("[A-Z]");
    private static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]");
    private static Pattern SPECIAL_SYMBOLS_PATTERN = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

    public static boolean validateObject(Object object) {
        Class clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Password.class)) {
                if (!isValidPassword((String) getValue(field, object))) {
                    return false;
                }
            }
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

    static boolean isValidPassword(String password) {
        if (password.length() < 8) return false;
        if (!LOWER_CASE_PATTERN.matcher(password).find()) return false;
        if (!UPPER_CASE_PATTERN.matcher(password).find()) return false;
        if (!NUMBER_PATTERN.matcher(password).find()) return false;
        return SPECIAL_SYMBOLS_PATTERN.matcher(password).find();
    }
}
