package annotations;

import annotations.annotations.Email;
import annotations.annotations.Max;
import annotations.annotations.Min;
import annotations.annotations.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import static annotations.ValidationHelper.isValidEmail;
import static annotations.ValidationHelper.validateObject;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationHelperTest {

    @Data
    @AllArgsConstructor
    static class ValidatedClass {

        private int id;

        private String name;

        @Email
        private String email;

        @Min(18)
        @Max(65)
        private int age;

        @Password
        private String password;

        @Password(
                length = 10,
                requireAlphaNumeric = false,
                requireSpecialSymbol = false,
                requireLowerAndUpperCase = false)
        private String password2;
    }

    private static final int VALID_AGE = 25;
    private static final String VALID_EMAIL = "info@test.com";
    private static final String VALID_PASSWORD = "Abc@123!";
    private static final String VALID_PASSWORD2 = "0123456789";

    @Test
    void testValidation() {
        assertFalse(validateObject(new ValidatedClass(1, "Tom", "blabla", VALID_AGE, VALID_PASSWORD, VALID_PASSWORD2)));
        assertTrue(validateObject(new ValidatedClass(2, "John", VALID_EMAIL, VALID_AGE, VALID_PASSWORD, VALID_PASSWORD2)));

        assertFalse(validateObject(new ValidatedClass(3, "Suzy", VALID_EMAIL, 12, VALID_PASSWORD, VALID_PASSWORD2)));
        assertFalse(validateObject(new ValidatedClass(4, "Jenny", VALID_EMAIL, 70, VALID_PASSWORD, VALID_PASSWORD2)));
        assertTrue(validateObject(new ValidatedClass(5, "Will", VALID_EMAIL, VALID_AGE, VALID_PASSWORD, VALID_PASSWORD2)));

        assertFalse(validateObject(new ValidatedClass(6, "Kelly", VALID_EMAIL, VALID_AGE, "abc", VALID_PASSWORD2)));
        assertTrue(validateObject(new ValidatedClass(7, "Rony", VALID_EMAIL, VALID_AGE, VALID_PASSWORD, VALID_PASSWORD2)));

        assertFalse(validateObject(new ValidatedClass(6, "Kelly", VALID_EMAIL, VALID_AGE, VALID_PASSWORD, "012345678")));
        assertTrue(validateObject(new ValidatedClass(6, "Kelly", VALID_EMAIL, VALID_AGE, VALID_PASSWORD, VALID_PASSWORD2)));
    }

    @Test
    void testEmailValidation() {
        assertFalse(isValidEmail(null));
        assertFalse(isValidEmail("@."));
        assertFalse(isValidEmail("asd"));
        assertFalse(isValidEmail("asd.sdf"));
        assertFalse(isValidEmail("asd@sdf"));
        assertFalse(isValidEmail("asd@sdf"));
        assertFalse(isValidEmail("asd@sdf@dfg"));
        assertFalse(isValidEmail("asd@sdf@dfg.fgh"));

        assertTrue(isValidEmail(VALID_EMAIL));
        assertTrue(isValidEmail("asd@sdf.sdf"));
        assertTrue(isValidEmail("asd@sdf.sdf.sdf"));
        assertTrue(isValidEmail("asd.sdf@sdf.sdf.sdf"));
    }

    @Test
    void testPasswordValidation() {
        assertFalse(isValidPassword("abc"));
        assertFalse(isValidPassword("abcDEF"));
        assertFalse(isValidPassword("1234567890"));
        assertFalse(isValidPassword("abcD1234"));
        assertFalse(isValidPassword("Abc?1!@"));
        assertFalse(isValidPassword("ABDCDEFGH123?!@#"));

        assertTrue(isValidPassword(VALID_PASSWORD));
        assertTrue(isValidPassword("Abc?123!"));
        assertTrue(isValidPassword("Abc?123!isdfih1"));
        assertTrue(isValidPassword("AbC1?@4156ajfh"));

        assertFalse(ValidationHelper.isValidPassword("password", 10, false, false, false));
        assertTrue(ValidationHelper.isValidPassword("password12", 10, false, false, false));

        assertFalse(ValidationHelper.isValidPassword("asd", 0, true, false, false));
        assertFalse(ValidationHelper.isValidPassword("123", 0, true, false, false));
        assertTrue(ValidationHelper.isValidPassword("asd123", 0, true, false, false));
        assertTrue(ValidationHelper.isValidPassword("ASD123", 0, true, false, false));

        assertFalse(ValidationHelper.isValidPassword("password", 0, false, true, false));
        assertTrue(ValidationHelper.isValidPassword("password!", 0, false, true, false));

        assertFalse(ValidationHelper.isValidPassword("password", 0, false, false, true));
        assertFalse(ValidationHelper.isValidPassword("PASSWORD", 0, false, false, true));
        assertTrue(ValidationHelper.isValidPassword("Password", 0, false, false, true));
    }

    private static boolean isValidPassword(String password) {
        return ValidationHelper.isValidPassword(password, 8, true, true, true);
    }
}