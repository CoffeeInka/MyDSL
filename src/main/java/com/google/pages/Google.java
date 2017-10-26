package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static core.ConciseAPI.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;

public class Google {

    public static By byResults = By.cssSelector(".srg>.g");

    public static void search(String query) {
        setValue($(By.name("q")), query + Keys.ENTER);
    }

    public static void followLink(int index) {
        getDriver().findElements(byResults).get(index).findElement(By.cssSelector(".r>a")).click();
    }

    public void assertResultsAmount(int resultsAmount) {
        assertThat(numberOfElementsToBe(byResults, resultsAmount));
    }
}
