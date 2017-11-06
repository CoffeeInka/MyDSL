package core.conditions;


import org.openqa.selenium.WebElement;

import java.util.List;

import static core.ConciseAPI.getDriver;

public abstract class CollectionCondition extends AbstractCondition<List<WebElement>> {

    @Override
    public List<WebElement> getWrappedEntity() {
        return getDriver().findElements(locator);
    }

    @Override
    public String identity() {
        return "elements: ";
    }
}
