package annotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Password {

    int length() default 8;
    boolean requireAlphaNumeric() default true;
    boolean requireSpecialSymbol() default true;
    boolean requireLowerAndUpperCase() default true;
}
