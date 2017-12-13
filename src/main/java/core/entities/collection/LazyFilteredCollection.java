package core.entities.collection;

import core.conditions.Condition;
import core.entities.element.LazyElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LazyFilteredCollection extends AbstractLazyCollection{

    LazyCollection collection;

    Condition<WebElement> condition;

    public LazyFilteredCollection(LazyCollection collection, Condition<WebElement> condition) {
        this.collection = collection;
        this.condition = condition;
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        List<WebElement> list = new ArrayList<>();
        for (LazyElement element:collection) {
           if(element.is(condition)){
            list.add(element.getWrappedEntity());
           }
        } return list;
    }

    @Override
    public String toString() {
        return "Collection " + collection +
                " filtered by condition " + condition.getClass().getSimpleName();
    }
}
