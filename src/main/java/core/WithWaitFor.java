package core;

import core.conditions.Condition;
import core.entities.LazyElement;
import org.openqa.selenium.WebDriverException;

import static core.WaitFor.waitFor;

public class WithWaitFor {

    private LazyElement lazyElement;

    private Condition condition;

    public WithWaitFor(LazyElement lazyElement, Condition condition) {

        this.lazyElement = lazyElement;
        this.condition = condition;
    }

    public <V> V run(Command <V> command) {
        try {
            return command.execute(lazyElement);
        } catch (WebDriverException e) {
            waitFor(lazyElement).until(condition);
            return command.execute(lazyElement);
        }
    }
}
