package runner;

import java.util.Arrays;
import java.util.Collection;

public class MagicRunner implements Runnable {

    private Collection<Runnable> runners;

    public MagicRunner(Runnable... runners) {
        this.runners = Arrays.asList(runners);
    }

    @Override
    public void run() {
        runners.forEach(Runnable::run);
    }
}
