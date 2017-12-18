package core.entities.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static core.ConciseAPI.getDriver;
import static core.conditions.ElementConditions.visible;


public class LazyWrappedWebElement extends AbstractLazyElement {

    private WebElement element;

    public LazyWrappedWebElement(WebElement element) {
        this.element = element;
    }

    @Override
    public WebElement getWrappedEntity() {
        return this.element;
    }

    @Override
    public String toString() {
        return "Wrapped element " + element;
    }

}
