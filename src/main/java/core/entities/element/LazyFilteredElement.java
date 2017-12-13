package core.entities.element;

import core.conditions.Condition;
import core.entities.collection.LazyCollection;
import org.openqa.selenium.WebElement;

public class LazyFilteredElement extends AbstractLazyElement {

    LazyCollection collection;

    Condition<WebElement> condition;


    public LazyFilteredElement(LazyCollection collection, Condition<WebElement> condition) {
        this.collection = collection;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Collection " + collection + " filtered by condition" + condition.getClass().getSimpleName();
    }

    @Override
    public WebElement getWrappedEntity() {
        WebElement entity = null;
        for (LazyElement element : collection) {
            if (element.is(condition)) {
                entity = element.getWrappedEntity();
                break;
            }
        }
        return entity;
    }
}
