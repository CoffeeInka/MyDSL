package core.conditions;


import core.exceptions.WebDriverAssertionException;
import core.entities.LazyEntity;

public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult {

    public LazyEntity lazyEntity;

    public T apply(LazyEntity<T> lazyEntity) {
        this.lazyEntity = lazyEntity;
        T entity = lazyEntity.getWrappedEntity();
        if(entity != null) {
            if (check(entity)) {
                return entity;
            }
        } throw new WebDriverAssertionException();
    }

    public abstract boolean check(T entity);

    public String toString() {
        return this.getClass().getSimpleName() +
                "\nfor " + lazyEntity.identity() + lazyEntity +
                "\nexpected result is " + expected() + "\n" +
                "actual result is " + actual();
    }
}
