package core.conditions.parents;


import org.openqa.selenium.WebElement;

import static core.ConciseAPI.getDriver;

public abstract class ElementCondition extends AbstractCondition<WebElement> {

    @Override
    public WebElement getWrappedEntity() {
        WebElement element = getDriver().findElement(locator);
        return element;
    }
}
