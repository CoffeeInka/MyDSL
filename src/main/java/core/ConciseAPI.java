package core;


import core.conditions.Condition;
import core.entities.LazyEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

import static core.Configuration.pollingInterval;
import static core.Configuration.timeout;
import static core.conditions.ElementConditions.visible;
import static core.WaitFor.waitFor;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

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

    public static WebElement $(By locator) {
        return assertThat(locator, visible());
    }


    public static WebElement setValue(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        return element;
    }

//    public static <V> V assertThat(By locator, Condition<V> condition) {
//        return waitFor(locator).until(condition);
//    }

    public static <V> V assertThat(LazyEntity lazyEntity, Condition<V> condition) {
        //return waitFor(locator).until(condition);
        return waitFor(lazyEntity).until(condition);
    }

    //ONLY for conditions without element, lists or locators
    public static <V> V assertThat(ExpectedCondition<V> condition) {
        return assertThat(condition, timeout, pollingInterval);
    }

    //ONLY for conditions without element, lists or locators
    public static <V> V assertThat(ExpectedCondition<V> condition, long timeout, long polling) {
        return new FluentWait<>(getDriver())
                .withTimeout(timeout, TimeUnit.MILLISECONDS)
                .pollingEvery(polling, TimeUnit.MILLISECONDS)
                .ignoring(WebDriverException.class, IndexOutOfBoundsException.class).until(condition);
    }

    public static void assertUrl(String url) {
        assertThat(urlToBe(url));
    }

}
