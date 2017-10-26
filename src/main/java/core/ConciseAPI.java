package core;


import conditions.Condition;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

import static conditions.MyExpectedConditions.visible;
import static core.Configuration.timeout;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ConciseAPI {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return ConciseAPI.driver;
    }

    public static void setDriver(WebDriver driver) {
        ConciseAPI.driver = driver;
    }

    public static void open(String url) {
        getDriver().get(url);
    }

    public static WebElement $(By elementLocator) {
        return assertThat(elementLocator, visible());
    }

    public static WebElement setValue(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        return element;
    }

    public static <V> V assertThat(By locator, Condition<V> condition) {
        return waitUntil(locator, condition, Configuration.timeout, Configuration.pollingInterval);
    }

    public static <V> V waitUntil(By locator, Condition<V> condition, long timeOutInMillis, long pollingIntervalInMillis) {
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

}
