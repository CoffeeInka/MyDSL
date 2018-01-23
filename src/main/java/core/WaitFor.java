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

    public static <V> V until(LazyEntity lazyEntity, long timeoutMs, Condition<V>... conditions) {
        if (conditions.length == 0) {
            throw new IllegalArgumentException("Conditions are not given");
        }
        V result = null;
        for (Condition<V> condition : conditions) {
            result = new FluentWait<LazyEntity>(lazyEntity)
                    .withTimeout(timeoutMs, TimeUnit.MILLISECONDS)
                    .pollingEvery(Configuration.pollingInterval, TimeUnit.MILLISECONDS)
                    .ignoring(WebDriverException.class)
                    .until(condition);
        }
        return result;
    }

    public static <V> V until(LazyEntity lazyEntity, Condition<V>... conditions) {
        return until(lazyEntity, Configuration.timeout, conditions);
    }

    public static boolean satisfied(LazyEntity lazyEntity, long timeoutMs, Condition... conditions) {
        try {
            until(lazyEntity, conditions);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}