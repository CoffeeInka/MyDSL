package com.google;

import com.google.testconfigs.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.google.pages.Google.*;
import static conditions.MyExpectedConditions.nthElementText;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;


public class GoogleSearchTest extends BaseTest {


    @Test
    public void testSearchThenFollowLink() {

        open("http://www.google.com");
        search("Selenium automates browsers");
        assertResultsAmount(10);
        assertThat(byResults, nthElementText(0, "Selenium automates browsers"));

        followLink(0);
        assertThat(By.cssSelector("#mainContent>h2"),nthElementText(0, "What is Selenium?"));
        assertThat(urlToBe("http://www.seleniumhq.org/"));
    }

}

