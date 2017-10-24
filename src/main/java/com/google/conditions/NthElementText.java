package com.google.conditions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.google.core.DSL.getDriver;

public class NthElementText extends Condition<WebElement> {

    private String expectedText;
    private int index;
    private String actualText;

    NthElementText(int index, String expectedText) {
        this.expectedText = expectedText;
        this.index = index;
    }

    @Override
    public WebElement apply(By locator) {
        List<WebElement> elementsList = getDriver().findElements(locator);
        try {
            WebElement element = elementsList.get(index);
            actualText = element.getText();
            if (!(actualText.contains(expectedText))) {
                return null;
            }
            return element;
        } catch (IndexOutOfBoundsException | WebDriverException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("Expected text of element \nwith index %d is: %s \nwhile actual text is: %s", index, expectedText, actualText);
    }
}

