package core.entities;


import core.conditions.Condition;
import org.openqa.selenium.WebElement;

import static core.WaitFor.waitFor;

public abstract class AbstractLazyElement implements LazyElement {

    public LazyElement should(Condition<WebElement> condition) {
        return waitFor(this).until(condition);
    }


    public LazyElement shouldBe(Condition<WebElement> condition) {
        return waitFor(this).until(condition);
    }

    public LazyElement shouldHave(Condition<WebElement> condition) {
        return waitFor(this).until(condition);
    }


}
