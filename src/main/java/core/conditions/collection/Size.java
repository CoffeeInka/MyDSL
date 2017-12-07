package core.conditions.collection;


import core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Size extends AbstractCondition<List<WebElement>> {

    private int expectedSize;
    private int actualSize;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public boolean check(List<WebElement> elements) {
        actualSize = elements.size();
        return (actualSize == expectedSize);
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
