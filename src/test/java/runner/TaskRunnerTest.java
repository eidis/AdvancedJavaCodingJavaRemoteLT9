package runner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskRunnerTest {

    @Test
    void checkTaskRunner() {
        Runnable r1 = new TaskRunner();
        Assertions.assertTrue(r1 instanceof TaskRunner);
        r1.run();

        System.out.println("=====");
        Runnable r2 = new MagicRunner(
                new TaskRunner(),
                new MagicTaskRunner(),
                new TaskRunner());
        Assertions.assertTrue(r2 instanceof MagicRunner);
        r2.run();
    }
}
