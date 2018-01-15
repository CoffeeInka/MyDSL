package core.conditions;


import core.conditions.element.*;
import org.openqa.selenium.WebElement;

public class ElementConditions {

    public static Condition<WebElement> visible() {
        return new Visible();
    }

    public static Condition<WebElement> text(String text) {
        return new Text(text);
    }

    public static Condition<WebElement> exactText(String text) {
        return new ExactText(text);
    }

    public static Condition<WebElement> present() {
        return new Present();
    }

    public static Condition<WebElement> cssClass(String className) {
        return new CssClass(className);
    }

}
