package core.entities.element;

import core.entities.collection.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.AbstractCollection;

public class LazyCollectionNthElement extends AbstractLazyElement {

    LazyCollection collection;

    int index;

    public LazyCollectionNthElement(LazyCollection collection, int index) {
    }

    @Override
    public WebElement getWrappedEntity() {
        return this.collection;
    }

    @Override
    public String toString() {
        return "Wrapped element " + element;
    }
}
