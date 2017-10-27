package core.conditions.standalone;


import core.conditions.parents.CollectionCondition;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SizeOf extends CollectionCondition {

    private int expectedSize;
    private int actualSize;

    public SizeOf(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {
        if (expectedSize == 0) {
            throw new IllegalArgumentException("Array of expected assets is empty.");
        }
        try {
            actualSize = elements.size();
            if (!(actualSize == expectedSize)) {
                return null;
            }
            return elements;
        } catch (IndexOutOfBoundsException | WebDriverException e) {
            return null;
        }
    }

//    @Override
//    public String toString() {
//        return String.format("Expected number of elements is: %s \nwhile actual number is: %s", expectedSize, actualSize);
//    }

    @Override
    public String identity() {
        return "number of elements";
    }

    @Override
    public String expected() {
        return Integer.toString(expectedSize);
    }

    @Override
    public String actual() {
        return Integer.toString(actualSize);
    }

}
