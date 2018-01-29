package core.conditions;


import core.entities.LazyEntity;

import java.util.function.Function;

public interface Condition<T> extends Function<LazyEntity<T>, T>, Matcher<T> {

}
