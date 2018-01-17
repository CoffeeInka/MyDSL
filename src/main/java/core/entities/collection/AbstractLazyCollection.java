package core.entities.collection;


import core.conditions.Condition;
import core.entities.LazyCollection;
import core.entities.LazyElement;
import core.entities.element.LazyCollectionFoundByConditionElement;
import core.entities.element.LazyCollectionNthElement;
import core.entities.element.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static core.WaitFor.waitFor;

public abstract class AbstractLazyCollection implements LazyCollection {

    @Override
    public String identity() {
        return "Collection";
    }

    @Override
    public LazyCollection should(Condition<List<WebElement>> condition) {
        waitFor(this).until(condition);
        return this;
    }

    @Override
    public LazyCollection shouldBe(Condition<List<WebElement>> condition) {
        return this.should(condition);
    }

    @Override
    public LazyCollection shouldHave(Condition<List<WebElement>> condition) {
        return this.should(condition);
    }

    @Override
    public Iterator<LazyElement> iterator() {
        List<LazyElement> list = new ArrayList<>();
        for (WebElement element : this.getWrappedEntity()) {
            list.add(new LazyWrappedWebElement(element));
        }
        return list.iterator();
    }

    @Override
    public LazyElement get(int index) {
        return new LazyCollectionNthElement(this, index);
    }

    @Override
    public LazyCollection filter(Condition<WebElement> condition) {
        return new LazyFilteredCollection(this, condition);
    }

    @Override
    public LazyElement find(Condition<WebElement> condition) {
        return new LazyCollectionFoundByConditionElement(this, condition);
    }

}

