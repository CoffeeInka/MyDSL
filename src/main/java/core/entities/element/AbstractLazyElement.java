package core.entities.element;


import core.conditions.Condition;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static core.WaitFor.waitFor;
import static core.conditions.ElementConditions.visible;

public abstract class AbstractLazyElement implements LazyElement {

    public String identity(){
        return "Element";
    }

    public LazyElement should(Condition<WebElement> condition) {
        waitFor(this).until(condition);
        return this;
    }

    public LazyElement shouldBe(Condition<WebElement> condition) {
        return this.should(condition);
    }

    public LazyElement shouldHave(Condition<WebElement> condition) {
        return this.should(condition);
    }

    public LazyElement setValue(String value){
        this.shouldBe(visible());
        getWrappedEntity().clear();
        getWrappedEntity().sendKeys(value);
        return this;
    }

    public LazyElement pressEnter(){
        this.shouldBe(visible());
        getWrappedEntity().sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement click(){
        this.shouldBe(visible());
        getWrappedEntity().click();
        return this;
    }
}
