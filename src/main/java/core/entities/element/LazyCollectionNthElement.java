package core.entities.element;

import core.entities.collection.LazyCollection;
import org.openqa.selenium.WebElement;

public class LazyCollectionNthElement extends AbstractLazyElement {

    LazyCollection collection;
    int index;

    public LazyCollectionNthElement(LazyCollection collection, int index) {
        this.collection = collection;
        this.index = index;
    }

    @Override
    public WebElement getWrappedEntity() {
        try {
            return collection.getWrappedEntity().get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds exception occurred");
        }
        return null;
    }

    @Override
    public String toString() {
        return " Wrapped nth element " + collection.getWrappedEntity().get(index);
    }
}
