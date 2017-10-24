package conditions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.DSL.getDriver;

public class SizeOf extends Condition<List<WebElement>> {

    private int expectedNumber;
    private int actualNumber;

    SizeOf(int expectedNumber) {
        this.expectedNumber = expectedNumber;
    }

    @Override
    public List<WebElement> apply(By locator) {
        if (expectedNumber == 0) {
            throw new IllegalArgumentException("Array of expected assets is empty.");
        }
        List<WebElement> elementsList = getDriver().findElements(locator);
        try {
            actualNumber = elementsList.size();
            if (!(actualNumber == expectedNumber)) {
                return null;
            }
            return elementsList;
        } catch (IndexOutOfBoundsException | WebDriverException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("Expected number of elements is: %s \nwhile actual number is: %s", expectedNumber, actualNumber);
    }

}
