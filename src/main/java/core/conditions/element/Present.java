package core.conditions.element;

import core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;

public class Present extends AbstractCondition<WebElement> {

    private boolean result;

    @Override
    public boolean check(WebElement element) {
        result = (element != null);
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
