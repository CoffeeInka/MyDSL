package core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ExactTexts extends TextsOf {

    public ExactTexts(String... expectedTexts) {
        super(expectedTexts);
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
            if (!elements.get(i).getText().equals(expectedTexts[i])) {
                return false;
            }
        }
        return true;
    }

}
