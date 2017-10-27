package core.conditions.standalone;


import core.conditions.parents.ElementCondition;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    @Override
    public WebElement check(WebElement element) {
        try {
            if (!(element.isDisplayed())) {
                return null;
            }
            return element;
        } catch (IndexOutOfBoundsException | WebDriverException e) {
            return null;
        }
    }

//    @Override
//    public String toString() {
//        return "Waiting for element to be displayed but failed";
//    }

    @Override
    public String identity() {
        return "element";
    }

    @Override
    public String expected() {
        return "to be displayed";
    }

    @Override
    public String actual() {
        return "not displayed";
    }
}
