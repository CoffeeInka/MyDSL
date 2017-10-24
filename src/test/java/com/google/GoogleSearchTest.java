package com.google;

import com.google.conditions.Condition;
import com.google.conditions.MyExpectedConditions;
import com.google.core.Configuration;
import com.google.testconfigs.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.conditions.MyExpectedConditions.*;
import static com.google.core.Configuration.timeout;
import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;


public class GoogleSearchTest extends BaseTest {


    @Test
    public void testSearchThenFollowLink() {

        open("http://www.google.com");
        search("Selenium automates browsers");
        assertResultsAmount(10);
        assertThat(byResults, nthElementText(0, "Selenium automates browsers"));
    }

    public static By byResults = By.cssSelector(".srg>.g");

    public static void search(String query) {
        setValue($(By.name("q")), query + Keys.ENTER);
    }

    public static WebElement setValue(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        return element;
    }

    public void assertResultsAmount(int resultsAmount) {
        assertThat(numberOfElementsToBe(byResults, resultsAmount));
    }

    public static <V> V assertThat(ExpectedCondition<V> condition, long timeout, long polling) {
        return new FluentWait<>(getDriver())
                .withTimeout(timeout, TimeUnit.MILLISECONDS)
                .pollingEvery(polling, TimeUnit.MILLISECONDS)
                .ignoring(WebDriverException.class, IndexOutOfBoundsException.class).until(condition);
    }

    public static <V> V assertThat(ExpectedCondition<V> condition) {
        return assertThat(condition, timeout, Configuration.pollingInterval);
    }

    public static WebElement assertThat(By locator, Condition condition) {
        return waitUntil(locator, condition, Configuration.timeout, Configuration.pollingInterval);
    }

    public static <V> V waitUntil(By locator, com.google.conditions.Condition <V> condition, long timeOutInMillis, long pollingIntervalInMillis) {
        long end = System.currentTimeMillis() + timeOutInMillis;
        Throwable lastException;
        while (true) {
            try {
                WebElement value = condition.apply(locator);
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
                        timeOutInMillis/1000, pollingIntervalInMillis);
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

//        open("http://www.google.com");
//
//        search("Selenium automates browsers");
//        assertResultsAmount(10);
//        byResults.first().shouldHave(text("Selenium automates browsers"));
//
//        followLink(0);
//        $("#mainContent>h2").shouldBe(visible);
//        assertEquals(url(), "http://www.seleniumhq.org/");
//    }
//
//    private void search(String query) {
//        $(By.name("q")).setValue(query).pressEnter();
//    }
//
//    public void followLink(int index) {
//        byResults.get(index).find(".r>a").click();
//    }
//
//    public ElementsCollection byResults = $$(".srg>.g");
//
//    public void assertResultsAmount(int resultsAmount) {
//        byResults.shouldHave(size(resultsAmount));
}

