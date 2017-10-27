package core.conditions.standalone;


import core.conditions.parents.CollectionCondition;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NthElementText extends CollectionCondition {

    private String expectedText;
    private int index;
    private String actualText;

    public NthElementText(int index, String expectedText) {
        this.expectedText = expectedText;
        this.index = index;
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {
        try {
            WebElement element = elements.get(index);
            actualText = element.getText();
            if (!(actualText.contains(expectedText))) {
                return null;
            }
            return elements;
        } catch (IndexOutOfBoundsException | WebDriverException e) {
            return null;
        }
    }

//    @Override
//    public String toString() {
//        return String.format("Expected text of element with index %d is: %s \nwhile actual text is: %s", index, expectedText, actualText);
//    }

    @Override
    public String identity() {
        return String.format("element with index %d", index);
    }

    @Override
    public String expected() {
        return expectedText;
    }

    @Override
    public String actual() {
        return actualText;
    }
}

