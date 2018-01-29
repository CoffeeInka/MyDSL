package core.conditions.collection;

import core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextsOf extends AbstractCondition<List<WebElement>> {

    protected String[] expectedTexts;
    protected List<String> actualTexts;

    public TextsOf(String... expectedTexts) {
        this.expectedTexts = expectedTexts;
    }

    @Override
    public boolean check(List<WebElement> elements) {
        actualTexts = new ArrayList<>();
        for (WebElement element : elements) {
            actualTexts.add(element.getText());
        }
        if (elements.size() != expectedTexts.length) {
            return false;
        }
        for (int i = 0; i < expectedTexts.length; i++) {
            if (!checkElement(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkElement(int index) {
        return actualTexts.get(index).contains(expectedTexts[index]);
    }

    @Override
    public String expected() {
        return Arrays.toString(expectedTexts);
    }

    @Override
    public String actual() {
        return Arrays.toString(actualTexts.toArray());
    }
}
