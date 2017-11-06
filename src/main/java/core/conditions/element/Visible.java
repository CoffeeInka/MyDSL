package core.conditions.element;


import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    private boolean result;

    @Override
    public boolean check(WebElement element) {
        result = element.isDisplayed();
        return result;
    }

    @Override
    public String expected() {
        return "true";
    }

    @Override
    public String actual() {
        return String.valueOf(result);
    }
}
