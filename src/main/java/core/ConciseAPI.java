package core;


import core.conditions.parents.Condition;
import org.openqa.selenium.*;

import static core.conditions.ElementConditions.visible;
import static core.conditions.wait.WaitFor.waitFor;

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

    public static <V> V assertThat(By locator, Condition<V> condition) {
        return waitFor(locator).until(condition);
    }

    public void assertUrl(String s) {
        //to implement
    }


}
