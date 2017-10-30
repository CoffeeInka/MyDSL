package core.conditions.element;


import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    @Override
    public boolean check(WebElement element) {
        return (element.isDisplayed());
    }

    @Override
    public String expected() {
        return "to be displayed";
    }

    @Override
    public String actual() {
        return "" + apply(locator);
    }
}
