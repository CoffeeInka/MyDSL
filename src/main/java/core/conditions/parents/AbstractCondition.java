package core.conditions.parents;


import org.openqa.selenium.By;

public abstract class AbstractCondition<V> implements Condition {

    public By locator;

    protected V apply(By locator){
        this.locator = locator;
        return check(getWrappedEntity());
    }

    public abstract V getWrappedEntity();

    public abstract V check(V entity);

    public String toString(){
        return this.getClass().getName() +
                "\nfor " + identity() + " found by: ___locator___\n" +
                "expected result is " + expected() + "\n" +
                "actual result is " + actual();
    }

    public abstract String identity();
    public abstract String expected();
    public abstract String actual();
}
