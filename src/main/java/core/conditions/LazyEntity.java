package core.conditions;


public interface LazyEntity<T> {
    T getWrappedEntity();
}
