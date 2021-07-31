package annotations;

import annotations.annotations.Email;
import annotations.annotations.Max;
import annotations.annotations.Min;
import annotations.annotations.Password;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class ValidationHelper {

    private static final Pattern LOWER_CASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern UPPER_CASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_SYMBOLS_PATTERN = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

    public static boolean validateObject(Object object) {
        Class clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Password.class)) {
                Password password = field.getAnnotation(Password.class);
                if (!isValidPassword(
                        (String) getValue(field, object),
                        password.length(),
                        password.requireAlphaNumeric(),
                        password.requireSpecialSymbol(),
                        password.requireLowerAndUpperCase()
                )) {
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

    static boolean isValidPassword(
            String password,
            int minLength,
            boolean requireAlphaNumeric,
            boolean requireSpecialSymbols,
            boolean requireLowerAndUpperCase
    ) {
        if (password.length() < minLength) return false;

        boolean hasLowerCaseLetter = LOWER_CASE_PATTERN.matcher(password).find();
        boolean hasUpperCaseLetter = UPPER_CASE_PATTERN.matcher(password).find();
        boolean hasNumbers = NUMBER_PATTERN.matcher(password).find();

        if (requireAlphaNumeric && (!(hasLowerCaseLetter || hasUpperCaseLetter) || !hasNumbers)) return false;
        if (requireSpecialSymbols && !SPECIAL_SYMBOLS_PATTERN.matcher(password).find()) return false;
        return !requireLowerAndUpperCase || (hasLowerCaseLetter && hasUpperCaseLetter);
    }
}
