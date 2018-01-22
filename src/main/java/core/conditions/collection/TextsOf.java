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
            if (!checkElement(i, elements)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkElement(int index, List<WebElement> elements) {
        return elements.get(index).getText().contains(expectedTexts[index]);
    }

    @Override
    public String expected() {
        return Arrays.toString(expectedTexts);
    }

    @Override
    public String actual() {
        String actual = "";
        for (String s : actualTexts) {
            actual += s + "\t";
        }
        return actual;
    }
}
