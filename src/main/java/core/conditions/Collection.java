package core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Collection extends Collections {

    public Collection(By locator){}

    @Override
    public Object getWrappedEntity() {
        return null;
    }

    @Override
    public List<WebElement> shouldHave() {
        return null;
    }
}
