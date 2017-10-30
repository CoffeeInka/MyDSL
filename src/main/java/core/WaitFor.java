package core;


import core.conditions.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

public class WaitFor {

    private By locator;

    WaitFor(By locator) {
        this.locator = locator;
    }

    public static WaitFor waitFor(By locator) {
        return new WaitFor(locator);
    }

    public <V> V until(Condition<V> condition) {
        return until(condition, Configuration.timeout, Configuration.pollingInterval);
    }

    public <V> V until(Condition<V> condition, long timeOutInMillis, long pollingIntervalInMillis) {
        long end = System.currentTimeMillis() + timeOutInMillis;
        Throwable lastException;
        while (true) {
            try {
                V value = condition.apply(locator);
                if (value != null) {
                    return value;
                }
                // Clear the last exception; if another retry or timeout exception would
                // be caused by a false or null value, the last exception is not the
                // cause of the timeout.
                lastException = null;
            } catch (Throwable e) {
                lastException = e;
//                lastException = propagateIfNotIgnored(e);
            }
            // Check the timeout after evaluating the function to ensure conditions
            // with a zero timeout can succeed.
            if (System.currentTimeMillis() > end) {
                String timeoutMessage = String.format(
                        "Expected condition failed: %s (tried for %d second(s) with %s interval in millis)",
                        "waiting for " + condition,
                        timeOutInMillis / 1000, pollingIntervalInMillis);
                throw new TimeoutException(timeoutMessage, lastException);
            }
            try {
                Thread.sleep(pollingIntervalInMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new WebDriverException(e);
            }
        }
    }

    private <V> void sleep() {
        try {
            Thread.sleep(Configuration.pollingInterval);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new WebDriverException(e);
        }
    }


//    public static <V> V until(By locator, Condition<V> condition, long timeOutInMillis, long pollingIntervalInMillis) {
//        long end = System.currentTimeMillis() + timeOutInMillis;
//        Throwable lastException;
//        while (true) {
//            try {
//                V value = condition.apply(locator);
//                if (value != null) {
//                    return value;
//                }
//                // Clear the last exception; if another retry or timeout exception would
//                // be caused by a false or null value, the last exception is not the
//                // cause of the timeout.
//                lastException = null;
//            } catch (Throwable e) {
//                lastException = e;
////                lastException = propagateIfNotIgnored(e);
//            }
//            // Check the timeout after evaluating the function to ensure conditions
//            // with a zero timeout can succeed.
//            if (System.currentTimeMillis() > end) {
//                String timeoutMessage = String.format(
//                        "Expected condition failed: %s (tried for %d second(s) with %s interval in millis)",
//                        "waiting for " + condition,
//                        timeOutInMillis / 1000, pollingIntervalInMillis);
//                throw new TimeoutException(timeoutMessage, lastException);
//            }
//            try {
//                Thread.sleep(pollingIntervalInMillis);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                throw new WebDriverException(e);
//            }
//        }
//    }

}
