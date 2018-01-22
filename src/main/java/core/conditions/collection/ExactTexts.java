package core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ExactTexts extends TextsOf {

    public ExactTexts(String... expectedTexts) {
        super(expectedTexts);
    }

    @Override
    public boolean checkElement(int index, List<WebElement> elements) {
        return elements.get(index).getText().equals(expectedTexts[index]);
    }

}
