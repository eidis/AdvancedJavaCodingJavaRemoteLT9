package annotations;

import annotations.annotations.Email;
import annotations.annotations.Min;
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
        private int age;
    }

    @Test
    void testValidation() {
        assertFalse(validateObject(new ValidatedClass(1, "Tom", "blabla", 25)));
        assertTrue(validateObject(new ValidatedClass(2, "John", "a@b.c", 25)));

        assertFalse(validateObject(new ValidatedClass(2, "Suzy", "a@b.c", 12)));
        assertTrue(validateObject(new ValidatedClass(2, "Jenny", "a@b.c", 30)));
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

        assertTrue(isValidEmail("a@b.c"));
        assertTrue(isValidEmail("asd@sdf.sdf"));
        assertTrue(isValidEmail("asd@sdf.sdf.sdf"));
        assertTrue(isValidEmail("asd.sdf@sdf.sdf.sdf"));
    }
}