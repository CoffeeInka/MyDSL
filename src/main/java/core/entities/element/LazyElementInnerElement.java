package core.entities.element;

import core.entities.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LazyElementInnerElement extends AbstractLazyElement {

    private LazyElement parentElement;

    private By locator;

    private String innerSelector;

    public LazyElementInnerElement(LazyElement parentElement, By locator) {

        this.parentElement = parentElement;

        this.locator = locator;

    }

    @Override
    public String toString() {
        return parentElement.toString() + " find(" + innerSelector + ")";
    }

    @Override
    public WebElement getWrappedEntity() {
        return parentElement.getWrappedEntity() == null ? null : parentElement.getWrappedEntity().findElement(By.cssSelector(innerSelector));
    }


}
