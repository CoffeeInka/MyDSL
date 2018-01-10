package core;


import core.conditions.Condition;
import core.entities.LazyEntity;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

public class WaitFor<T> {

    private LazyEntity <T> lazyEntity;

    WaitFor(LazyEntity<T> lazyEntity) {
        this.lazyEntity = lazyEntity;
    }

    public static <V> WaitFor<V> waitFor(LazyEntity <V> lazyEntity) {
        return new WaitFor(lazyEntity);
    }

    public T until(Condition<T> condition) {
        return until(condition, Configuration.timeout, Configuration.pollingInterval);
    }

    public T until(Condition<T> condition, long timeOutInMillis, long pollingIntervalInMillis) {
        long end = System.currentTimeMillis() + timeOutInMillis;
        Throwable lastException;
        while (true) {
            try {
                T value = condition.apply(lazyEntity);
                if (value != null) {
                    return value;
                }
                lastException = null;
            } catch (Throwable e) {
                lastException = e;
            }
            if (System.currentTimeMillis() > end) {
                String timeoutMessage = String.format(
                        "Expected condition failed: %s (tried for %d second(s) with %s interval in millis)",
                        "waiting for " + condition,
                        timeOutInMillis / 1000, pollingIntervalInMillis);
                throw new TimeoutException(timeoutMessage, lastException);
            }
            sleep(pollingIntervalInMillis);
        }
    }

    private void sleep(long timeOutInMillis) {
        try {
            Thread.sleep(timeOutInMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new WebDriverException(e);
        }
    }

}