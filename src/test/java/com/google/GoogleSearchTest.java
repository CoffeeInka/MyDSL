package com.google;

import com.testconfigs.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.google.pages.Google.followLink;
import static com.google.pages.Google.results;
import static com.google.pages.Google.search;
import static core.ConciseAPI.$;
import static core.ConciseAPI.assertUrl;
import static core.ConciseAPI.open;
import static core.conditions.CollectionConditions.size;
import static core.conditions.ElementConditions.text;


public class GoogleSearchTest extends BaseTest {


    @Test
    public void testSearchThenFollowLink() {

        open("http://www.google.com");
        search("Selenium automates browsers");
        results.shouldHave(size(10));
        results.get(0).shouldHave(text("Selenium automates browsers"));

        followLink(0);
        $(By.cssSelector("#mainContent>h2")).shouldHave(text("What is Selenium?"));
        assertUrl("http://www.seleniumhq.org/");
    }

}

