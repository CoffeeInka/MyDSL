package core.conditions;

import core.conditions.collection.Size;
import core.conditions.collection.NthElementText;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionConditions {

    public static Condition<List<WebElement>> size(int number) {
        return new Size(number);
    }

    public static Condition<List<WebElement>> nthElementText(int index, String text) {
        return new NthElementText(index, text);
    }
}
