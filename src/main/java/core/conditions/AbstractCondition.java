package core.conditions;


import org.openqa.selenium.By;

public abstract class AbstractCondition<T> implements Condition<T> {

    public By locator;

    public T apply(By locator) {
        this.locator = locator;
        T entity = getWrappedEntity();
        if (check(entity)) {
            return entity;
        }
        return null;
    }

//    public abstract T getWrappedEntity();

    public abstract boolean check(T entity);

    public String toString() {
        return this.getClass().getSimpleName() +
                "\nfor " + identity() + " found by locator: " + locator +
                "\nexpected result is " + expected() + "\n" +
                "actual result is " + actual();
    }

    public abstract String identity();

    public abstract String expected();

    public abstract String actual();
}
