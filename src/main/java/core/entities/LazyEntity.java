package core.entities;


public interface LazyEntity<T> {

    T getWrappedEntity();

    T identity();
}
