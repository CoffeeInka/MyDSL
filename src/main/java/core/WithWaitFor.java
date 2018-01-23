package core;

import core.conditions.Condition;
import core.entities.LazyElement;
import org.openqa.selenium.WebDriverException;

import static core.WaitFor.satisfied;

public class WithWaitFor {

    private LazyElement lazyElement;

    private Condition condition;

    public WithWaitFor(LazyElement lazyElement, Condition condition) {

        this.lazyElement = lazyElement;
        this.condition = condition;
    }

    public <V> V run(Command<V> command) {
        try {
            return command.execute(lazyElement.getWrappedEntity());
        } catch (WebDriverException e) {
            satisfied(lazyElement, Configuration.timeout, condition);
            return command.execute(lazyElement.getWrappedEntity());
        }
    }
}
