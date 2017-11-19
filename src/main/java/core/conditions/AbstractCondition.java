package core.conditions;


import core.elementsandcollections.LazyEntity;
import org.openqa.selenium.By;

public abstract class AbstractCondition<T> implements Condition<T> {

//    public By locator;

    public LazyEntity lazyEntity;

    public T apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
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
