package core.entities;


public interface LazyEntity<T> extends DescribesEntity{

    T getWrappedEntity();
}
