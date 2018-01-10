package core.entities.element;

import core.entities.LazyCollection;
import core.exceptions.LazyСollectionIndexOutOfBoundsException;
import org.openqa.selenium.WebElement;

public class LazyCollectionNthElement extends AbstractLazyElement {

    private LazyCollection collection;
    private int index;

    public LazyCollectionNthElement(LazyCollection collection, int index) {
        this.collection = collection;
        this.index = index;
    }

    @Override
    public WebElement fetchWrappedEntity() {
        try {
            return collection.getWrappedEntity().get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new LazyСollectionIndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return " Wrapped nth element " + collection.toString() + "[" + index + "]";
    }
}
