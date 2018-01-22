package core;


import core.entities.LazyCollection;
import core.entities.collection.LazyWebDriverCollection;
import core.entities.LazyElement;
import core.entities.element.LazyWebDriverElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static core.Configuration.pollingInterval;
import static core.Configuration.timeout;
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

    public static By byText(String text) {
        return By.xpath(String.format("//*[text()='%s']", text));
    }

    public static LazyElement $(By locator) {
        return new LazyWebDriverElement(locator);
    }

    public static LazyElement $(String cssSelector) {
        return new LazyWebDriverElement(By.cssSelector(cssSelector));
    }

    public static LazyCollection $$(By locator) {
        return new LazyWebDriverCollection(locator);
    }

    public static void assertUrl(String url) {
        waitFor(urlToBe(url));
    }

    public static void refresh() {
        getDriver().navigate().refresh();
    }

    public static void executeJavaScript(String jsCommand) {
        ((JavascriptExecutor) getDriver()).executeScript(jsCommand);
    }

    public static <V> V waitFor(ExpectedCondition<V> condition) {
        return new WebDriverWait(getDriver(), Configuration.timeout / 1000).until(condition);
    }

}
