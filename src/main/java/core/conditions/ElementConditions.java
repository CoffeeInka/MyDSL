package core.conditions;


import core.conditions.parents.Condition;
import core.conditions.standalone.NthElementText;
import core.conditions.standalone.Visible;
import org.openqa.selenium.WebElement;

public class ElementConditions{

    public static Condition<WebElement> nthElementText(int index, String text) {
        return new NthElementText(index, text);
    }

    public  static Condition <WebElement> visible(){
        return new Visible();
    }
}
