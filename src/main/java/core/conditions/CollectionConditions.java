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

    public static Condition<List<WebElement>> texts(String... texts) {
        return new TextsOf(texts);
    }

    public static Condition<List<WebElement>> exactTexts(String... texts) {
        return new ExactTexts(texts);
    }
}
