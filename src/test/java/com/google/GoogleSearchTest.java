package com.google;

import com.codeborne.selenide.*;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.*;


import static org.junit.Assert.*;


public class GoogleSearchTest {


    @Test
    public void testSearchThenFollowLink() {
        open("http://www.google.com");

        search("Selenium automates browsers");
        assertResultsAmount(10);
        results.first().shouldHave(text("Selenium automates browsers"));

        followLink(0);
        $("#mainContent>h2").shouldBe(visible);
        assertEquals(url(), "http://www.seleniumhq.org/");
    }

    private void search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
    }

    public void followLink(int index) {
        results.get(index).find(".r>a").click();
    }

    public ElementsCollection results = $$(".srg>.g");

    public void assertResultsAmount(int resultsAmount) {
        results.shouldHave(size(resultsAmount));
    }
}
