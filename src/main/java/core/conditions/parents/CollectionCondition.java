package core.conditions.parents;


import org.openqa.selenium.WebElement;

import java.util.List;

import static core.ConciseAPI.getDriver;

public abstract class CollectionCondition extends AbstractCondition<List<WebElement>> {

    @Override
    public List<WebElement> getWrappedEntity() {
        List<WebElement> elements = getDriver().findElements(locator);
        return elements;
    }
}
