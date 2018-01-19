package core.entities.element;

import core.entities.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LazyElementInnerElement extends AbstractLazyElement {
    private LazyElement parentElement;
    private By innerLocator;

    public LazyElementInnerElement(LazyElement parentElement, By innerLocator) {
        this.parentElement = parentElement;
        this.innerLocator = innerLocator;

    }

    @Override
    public String toString() {
        return parentElement.toString() + " find(" + innerLocator + ")";
    }

    @Override
    public WebElement fetchWrappedEntity() {
        return parentElement.getWrappedEntity().findElement(innerLocator);
    }


}
