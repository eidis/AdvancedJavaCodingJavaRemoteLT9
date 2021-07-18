package annotations.annotations;

public @interface Password {

    int length() default 8;
    boolean requireAlphaNumeric() default true;
    boolean requireSpecialSymbol() default true;
    boolean requireLowerAndUpperCase() default true;
}
