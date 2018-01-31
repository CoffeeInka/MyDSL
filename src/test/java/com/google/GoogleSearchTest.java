package com.google;

import com.testconfigs.BaseTest;
import org.junit.Test;

import static com.google.pages.Google.*;
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
        assertUrl("http://www.seleniumhq.org/");
    }
}

