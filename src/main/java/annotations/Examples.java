package annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Examples {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        processAnnotations(Examples.class);
    }

    private static void processAnnotations(Class<?> clazz) throws InvocationTargetException, IllegalAccessException {
        Examples examples = new Examples();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunMethod.class)) {
                boolean shouldWrap = false;
                String wrapperText = null;

                if (method.isAnnotationPresent(WrapSystemOutput.class)) {
                    WrapSystemOutput wrapSystemOutput = method.getAnnotation(WrapSystemOutput.class);
                    wrapperText = wrapSystemOutput.value();
                    shouldWrap = true;
                }
                if (shouldWrap) {
                    System.out.println(wrapperText);
                }
                method.invoke(examples);
                if (shouldWrap) {
                    System.out.println(wrapperText);
                }
            }
        }
    }

    @RunMethod
    @WrapSystemOutput
    public void testWrapSystemOutput() {
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");
    }

    @RunMethod
    @WrapSystemOutput("-----------------------")
    private void testLombok() {
        DataSample sample = new DataSample.DataSampleBuilder()
                .text("some text")
                .number(123)
                .build();

        System.out.println(sample.getText());
        sample.setNumber(234);
    }
}
