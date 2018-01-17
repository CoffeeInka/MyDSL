package core.conditions;


import core.entities.LazyEntity;

public interface Condition<T> extends Matcher<T> {

    T apply(LazyEntity<T> lazyEntity);

}
