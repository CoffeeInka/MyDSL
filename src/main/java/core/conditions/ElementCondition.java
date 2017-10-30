package core.conditions;


import org.openqa.selenium.WebElement;

import static core.ConciseAPI.getDriver;

public abstract class ElementCondition extends AbstractCondition<WebElement> {

    @Override
    public WebElement getWrappedEntity() {
        return getDriver().findElement(locator);
    }

    @Override
    public String identity() {
        return "element: " + getWrappedEntity();
    }
}
