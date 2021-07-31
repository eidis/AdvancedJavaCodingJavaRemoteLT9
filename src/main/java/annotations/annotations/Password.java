package annotations.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Password {

    int length() default 8;
    boolean requireAlphaNumeric() default true;
    boolean requireSpecialSymbol() default true;
    boolean requireLowerAndUpperCase() default true;
}
