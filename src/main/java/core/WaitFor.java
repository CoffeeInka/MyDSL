package core;


import core.conditions.Condition;
import core.entities.LazyEntity;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class WaitFor<T> {

    private LazyEntity<T> lazyEntity;

    WaitFor(LazyEntity<T> lazyEntity) {
        this.lazyEntity = lazyEntity;
    }

    public static <V> WaitFor<V> waitFor(LazyEntity<V> lazyEntity) {
        return new WaitFor(lazyEntity);
    }

    public T until(long timeoutMs, long pollingInterval, Condition<T>... conditions) {
        if (conditions.length == 0) {
            throw new IllegalArgumentException("Conditions are not given");
        }
        T result = null;
        for (Condition<T> condition : conditions) {
            result = new FluentWait<LazyEntity<T>>(lazyEntity)
                    .withTimeout(timeoutMs, TimeUnit.MILLISECONDS)
                    .pollingEvery(pollingInterval, TimeUnit.MILLISECONDS)
                    .ignoring(WebDriverException.class)
                    .until(condition);
        }
        return result;
    }

    public T until(Condition<T>... conditions) {
        return until(Configuration.timeout, Configuration.pollingInterval, conditions);
    }

    public boolean satisfied(long timeoutMs, Condition... conditions) {
        try {
            until(conditions);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}