package com.google;

import com.google.core.Configuration;
import com.google.testconfigs.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;


public class GoogleSearchTest extends BaseTest {


    @Test
    public void testSearchThenFollowLink() {

        open("http://www.google.com");
        search("Selenium automates browsers");
        assertResultsAmount(10);
        List<WebElement> results = getDriver().findElements(byResults);
        assertThat(textToBePresentInElement(results.get(0), "Selenium automates browsers"));
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
        assertThat(numberOfElementsToBe(byResults, 10));
    }

    public static <V> V assertThat(ExpectedCondition<V> condition, long timeout, long polling) {
        return new FluentWait<>(getDriver())
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(polling, TimeUnit.MILLISECONDS)
                .ignoring(WebDriverException.class, IndexOutOfBoundsException.class).until(condition);
    }

    public static <V> V assertThat(ExpectedCondition<V> condition) {
        return assertThat(condition, Configuration.timeout, Configuration.pollingInterval);
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

