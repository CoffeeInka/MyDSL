package core.entities.collection;

import core.conditions.Condition;
import core.entities.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LazyFilteredCollection extends AbstractLazyCollection{

    private LazyCollection parentCollection;

    private Condition<WebElement> condition;

    public LazyFilteredCollection(LazyCollection parentCollection, Condition<WebElement> condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

//    @Override
//    public List<WebElement> getWrappedEntity() {
//        List<WebElement> list = new ArrayList<>();
//        for (LazyElement element:parentCollection) {
//           if(element.is(condition)){
//            list.add(element.getWrappedEntity());
//           }
//        } return list;
//    }

    @Override
    public List<WebElement> getWrappedEntity() {
        List<WebElement> list = new ArrayList<>();
        for (WebElement element: parentCollection.getWrappedEntity()) {
            if(condition.check(element)){
                list.add(element);
            }
        } return list;
    }

    @Override
    public String toString() {
        return parentCollection.toString() + " filter(" + condition.getClass().getSimpleName() + ")";
    }
}
