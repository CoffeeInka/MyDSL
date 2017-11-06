package core.conditions;


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
}
