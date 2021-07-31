package annotations;

import annotations.annotations.Email;
import annotations.annotations.Max;
import annotations.annotations.Min;
import annotations.annotations.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import static annotations.ValidationHelper.*;
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
    }

    private static final int VALID_AGE = 25;
    private static final String VALID_EMAIL = "info@test.com";
    private static final String VALID_PASSWORD = "Abc@123!";

    @Test
    void testValidation() {
        assertFalse(validateObject(new ValidatedClass(1, "Tom", "blabla", VALID_AGE, VALID_PASSWORD)));
        assertTrue(validateObject(new ValidatedClass(2, "John", VALID_EMAIL, VALID_AGE, VALID_PASSWORD)));

        assertFalse(validateObject(new ValidatedClass(3, "Suzy", VALID_EMAIL, 12, VALID_PASSWORD)));
        assertFalse(validateObject(new ValidatedClass(4, "Jenny", VALID_EMAIL, 70, VALID_PASSWORD)));
        assertTrue(validateObject(new ValidatedClass(5, "Will", VALID_EMAIL, VALID_AGE, VALID_PASSWORD)));

        assertFalse(validateObject(new ValidatedClass(6, "Kelly", VALID_EMAIL, VALID_AGE, "abc")));
        assertTrue(validateObject(new ValidatedClass(7, "Rony", VALID_EMAIL, VALID_AGE, VALID_PASSWORD)));
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
    }
}