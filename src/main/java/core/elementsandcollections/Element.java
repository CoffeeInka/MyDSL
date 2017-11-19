package core.elementsandcollections;

import core.conditions.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.ConciseAPI.getDriver;


public class Element extends AbstractLazyElement {

    private By locator;

    public Element(By locator) {
        this.locator = locator;
    }

    @Override
    public WebElement getWrappedEntity() {
        return getDriver().findElement(locator);
    }

    @Override
    public LazyElement shouldBe(Condition<WebElement> condition) {
        return null;
    }
}
