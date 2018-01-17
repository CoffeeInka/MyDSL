package core.entities.collection;

import core.entities.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyElementInnerCollection extends AbstractLazyCollection {

    private LazyElement element;

    private By innerLocator;

    public LazyElementInnerCollection(LazyElement element, By innerLocator) {

        this.element = element;

        this.innerLocator = innerLocator;
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        return element.findElements(innerLocator);
    }

    @Override
    public String toString() {
        return element + " findAll(" + innerLocator + ")";
    }
}

