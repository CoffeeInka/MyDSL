package com.google;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import java.security.Key;

import static com.google.core.DSL.$;
import static com.google.core.DSL.open;


public class GoogleSearchTest {


    @Test
    public void testSearchThenFollowLink() {

        open("http://www.google.com");
        search("Selenium automates browsers");
    }

    public void search(String query){
        setValue($(By.name("q")), query + Keys.ENTER);
    }

    public static WebElement setValue(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        return element;
    }

//        open("http://www.google.com");
//
//        search("Selenium automates browsers");
//        assertResultsAmount(10);
//        results.first().shouldHave(text("Selenium automates browsers"));
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
//        results.get(index).find(".r>a").click();
//    }
//
//    public ElementsCollection results = $$(".srg>.g");
//
//    public void assertResultsAmount(int resultsAmount) {
//        results.shouldHave(size(resultsAmount));
    }

