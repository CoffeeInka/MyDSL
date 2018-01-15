package com.google.testconfigs;

import core.ConciseAPI;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseTest extends ConciseAPI {

    @Before
    public void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette", false);
        setDriver(new FirefoxDriver(capabilities));
    }

    @After
    public void tearDown() {
        getDriver().quit();
    }

}

