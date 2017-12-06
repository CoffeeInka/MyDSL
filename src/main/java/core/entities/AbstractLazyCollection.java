package core.entities;


import core.WaitFor;
import core.conditions.Condition;

public abstract class AbstractLazyCollection implements LazyCollection {

    public LazyCollection should(Condition condition) {
         return WaitFor.waitFor(this).until(condition);
    }

    public LazyCollection shouldBe(Condition condition) {
        return WaitFor.waitFor(this).until(condition);
    }

    public LazyCollection shouldHave(Condition condition) {
        return WaitFor.waitFor(this).until(condition);
    }
}

