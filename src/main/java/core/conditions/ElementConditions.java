package core.conditions;


import core.conditions.element.ExactText;
import core.conditions.element.Present;
import core.conditions.element.Text;
import core.conditions.element.Visible;
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

}
