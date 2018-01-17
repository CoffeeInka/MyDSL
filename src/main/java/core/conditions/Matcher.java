package core.conditions;

public interface Matcher<T> {
    boolean check(T wrappedEntity);
}
