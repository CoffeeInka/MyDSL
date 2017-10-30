package core.conditions.collection;


import core.conditions.CollectionCondition;
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
    public boolean check(List<WebElement> elements) {
        WebElement element = elements.get(index);
        actualText = element.getText();
        return (actualText.contains(expectedText));
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

