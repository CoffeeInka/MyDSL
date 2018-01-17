package core.conditions;

import core.conditions.collection.ExactTexts;
import core.conditions.collection.Size;
import core.conditions.collection.TextsOf;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionConditions {

    public static Condition<List<WebElement>> size(int number) {
        return new Size(number);
    }

    public static Condition<List<WebElement>> texts(String... expectedTexts) {
        return new TextsOf(expectedTexts);
    }

    public static Condition<List<WebElement>> exactTexts(String... expectedTexts) {
        return new ExactTexts(expectedTexts);
    }
}
