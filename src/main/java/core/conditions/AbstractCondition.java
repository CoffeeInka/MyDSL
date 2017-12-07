package core.conditions;


import core.entities.LazyEntity;

public abstract class AbstractCondition<T> implements Condition<T> {

    public LazyEntity lazyEntity;

    public T apply(LazyEntity<T> lazyEntity) {
        this.lazyEntity = lazyEntity;
        T entity = lazyEntity.getWrappedEntity();
        if (check(entity)) {
            return entity;
        }
        return null;
    }

    public abstract boolean check(T entity);

    public String toString() {
        return this.getClass().getSimpleName() +
                "\nfor " + lazyEntity.identity() + lazyEntity +
                "\nexpected result is " + expected() + "\n" +
                "actual result is " + actual();
    }

    public abstract String expected();

    public abstract String actual();
}
