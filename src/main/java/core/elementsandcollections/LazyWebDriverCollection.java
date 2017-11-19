package core.elementsandcollections;

import core.conditions.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.ConciseAPI.getDriver;
import static core.WaitFor.waitFor;


public class LazyWebDriverCollection extends AbstractLazyCollection {

    private By locator;

    public LazyWebDriverCollection(By locator) {
        this.locator = locator;
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        return getDriver().findElements(locator);
    }

    public LazyEntity should(Condition<T> condition){
        return waitFor(getWrappedEntity()).until(condition);
    }

    @Override
    public LazyCollection shouldHave(Condition<List<WebElement>> condition) {
        return null;
    }
}
