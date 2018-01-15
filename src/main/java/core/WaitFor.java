package core;


import core.conditions.Condition;
import core.entities.LazyEntity;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

public class WaitFor<T> {

    private LazyEntity<T> lazyEntity;

    WaitFor(LazyEntity<T> lazyEntity) {
        this.lazyEntity = lazyEntity;
    }

    public static <V> WaitFor<V> waitFor(LazyEntity<V> lazyEntity) {
        return new WaitFor(lazyEntity);
    }

    public T until(Condition<T> condition) {
        return until(condition, Configuration.timeout, Configuration.pollingInterval);
    }

    public T until(Condition<T> condition, long timeoutMs, long pollingIntervalInMillis) {
        final long startTime = System.currentTimeMillis();
        Throwable lastError;
        do {
            try {
                return condition.apply(lazyEntity);
            } catch (WebDriverException e) {
                lastError = e;
            }
            sleep(pollingIntervalInMillis);
        } while (System.currentTimeMillis() - startTime < timeoutMs);

        throw new TimeoutException("\nfailed while waiting " + timeoutMs / 1000 + " seconds" +
                "\nto assert " + condition, lastError);
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