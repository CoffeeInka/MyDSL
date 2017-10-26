package conditions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import static core.ConciseAPI.getDriver;

public class Visible extends Condition<WebElement> {

    @Override
    public WebElement apply(By locator) {
        WebElement element = getDriver().findElement(locator);
        try {
            if (!(element.isDisplayed())) {
                return null;
            }
            return element;
        } catch (IndexOutOfBoundsException | WebDriverException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Waiting for element to be displayed but failed";
    }
}
