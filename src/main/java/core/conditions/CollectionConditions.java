package core.conditions;

import core.conditions.parents.Condition;
import core.conditions.standalone.SizeOf;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionConditions {

    public static Condition<List<WebElement>> size(int expectedNumber) {
        return new SizeOf(expectedNumber);
    }
}
