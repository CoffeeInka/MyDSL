package core.entities.collection;


import core.conditions.Condition;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.WaitFor.waitFor;

public abstract class AbstractLazyCollection implements LazyCollection {

    public String identity(){
        return "Collection";
    }

    public LazyCollection should(Condition<List<WebElement>>  condition) {
          waitFor(this).until(condition);
          return this;
    }

    public LazyCollection shouldBe(Condition<List<WebElement>>  condition) {
        return this.should(condition);
    }

    public LazyCollection shouldHave(Condition<List<WebElement>>  condition) {
        return this.should(condition);
    }

}

