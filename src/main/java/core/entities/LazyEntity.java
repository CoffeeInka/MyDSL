package core.entities;


public interface LazyEntity<T> {

    T getWrappedEntity();

    String identity();
}
