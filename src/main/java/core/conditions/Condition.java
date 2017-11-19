package core.conditions;


import core.elementsandcollections.LazyEntity;

public interface Condition<T> {

    T apply(LazyEntity<T> lazyEntity);


}
