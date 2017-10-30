package core.conditions;

import core.conditions.collection.NthElementText;
import core.conditions.collection.SizeOf;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionConditions {

    public static Condition<List<WebElement>> size(int expectedNumber) {
        return new SizeOf(expectedNumber);
    }

    public static Condition<List<WebElement>> nthElementText(int index, String text) {
        return new NthElementText(index, text);
    }
}
