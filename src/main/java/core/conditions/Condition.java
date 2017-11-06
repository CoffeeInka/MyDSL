package core.conditions;


import org.openqa.selenium.By;

public interface Condition<T> {

    T getWrappedEntity();

    T apply(By locator);
}
