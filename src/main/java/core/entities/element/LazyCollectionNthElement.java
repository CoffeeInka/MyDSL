package core.entities.element;

import core.entities.LazyCollection;
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
        return null;
    }

    @Override
    public String toString() {
        return " Wrapped nth element " + collection.toString() + "[" + index + "]";
    }
}
