package com.google;

import com.google.testconfigs.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.google.pages.Google.*;
import static core.conditions.CollectionConditions.nthElementText;
import static core.conditions.CollectionConditions.size;
import static core.conditions.ElementConditions.text;


public class GoogleSearchTest extends BaseTest {


    @Test
    public void testSearchThenFollowLink() {

        open("http://www.google.com");
        search("Selenium automates browsers");
        results.shouldHave(size(10));
        results.shouldHave(nthElementText(0, "Selenium automates browsers"));

        followLink(0);
        $(By.cssSelector("#mainContent>h2")).shouldHave(text("What is Selenium?"));
        assertUrl("http://www.seleniumhq.org/");
    }

}

