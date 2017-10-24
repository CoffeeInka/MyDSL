package com.google;

import com.google.testconfigs.BaseTest;
import org.junit.Test;

import static com.google.pages.Google.byResults;
import static com.google.pages.Google.search;
import static conditions.MyExpectedConditions.nthElementText;


public class GoogleSearchTest extends BaseTest {


    @Test
    public void testSearchThenFollowLink() {

        open("http://www.google.com");
        search("Selenium automates browsers");
        assertResultsAmount(10);
        assertThat(byResults, nthElementText(0, "Selenium automates browsers"));
    }

//
//        followLink(0);
//        $("#mainContent>h2").shouldBe(visible);
//        assertEquals(url(), "http://www.seleniumhq.org/");
//    }

//
//    public void followLink(int index) {
//        byResults.get(index).find(".r>a").click();
//    }

}

