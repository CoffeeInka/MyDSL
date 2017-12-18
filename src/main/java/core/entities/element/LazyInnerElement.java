package core.entities.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static core.ConciseAPI.getDriver;
import static core.conditions.ElementConditions.visible;

public class LazyInnerElement extends AbstractLazyElement {

    LazyElement parentElement;

    By locator;

    String innerSelector;


    public LazyInnerElement(LazyElement parentElement, By locator) {

        this.parentElement = parentElement;

        this.locator = locator;
    }

    public LazyInnerElement(LazyElement parentElement, String innerSelector) {

        this.parentElement = parentElement;

        this.innerSelector = innerSelector;

        locator = By.cssSelector(innerSelector);

    }

    @Override
    public String toString() {
        return "Parent element " + parentElement + " by locator " + locator;
    }

    @Override
    public WebElement getWrappedEntity() {
        return this.parentElement.getWrappedEntity().findElement(locator);
    }


}
