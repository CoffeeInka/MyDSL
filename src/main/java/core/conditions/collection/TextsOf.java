package core.conditions.collection;

import core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextsOf extends AbstractCondition<List<WebElement>> {

    private String[] expectedTexts;
    private List<String> actualTexts;

    public TextsOf(String... expectedTexts) {
        this.expectedTexts = expectedTexts;
    }

    @Override
    public boolean check(List<WebElement> elements) {
        if (elements.size() == 0) {
            throw new IllegalArgumentException("Array of expected texts is empty.");
        }
        actualTexts = new ArrayList<>();
        for (WebElement element : elements) {
            actualTexts.add(element.getText());
        }
        if (elements.size() != expectedTexts.length) {
            return false;
        }
        for (int i = 0; i < expectedTexts.length; i++) {
            if (!elements.get(i).getText().contains(expectedTexts[i])) {
                return false;
            }
        }
        return true;
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
