package core.entities.element;

import core.conditions.Condition;
import core.entities.LazyCollection;
import core.exceptions.ElementNotFoundException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyCollectionFoundByConditionElement extends AbstractLazyElement {

    private LazyCollection parentCollection;

    private Condition<WebElement> condition;


    public LazyCollectionFoundByConditionElement(LazyCollection collection, Condition<WebElement> condition) {
        this.parentCollection = collection;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return parentCollection.toString() + " find(" + condition.getClass().getSimpleName() + ")";
    }

    @Override
    public WebElement fetchWrappedEntity() {
        List<WebElement> list = parentCollection.getWrappedEntity();

        for (WebElement element : list) {
            if (condition.check(element)) {
                return element;
            }
        }

        throw new ElementNotFoundException(toString());
    }

}
