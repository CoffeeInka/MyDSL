package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static core.DSL.$;
import static core.DSL.getDriver;
import static core.DSL.setValue;

public class Google {

    public static By byResults = By.cssSelector(".srg>.g");

    public static void search(String query) {
        setValue($(By.name("q")), query + Keys.ENTER);
    }

    public static void followLink(int index) {
        getDriver().findElements(byResults).get(index).findElement(By.cssSelector(".r>a")).click();
    }
}
