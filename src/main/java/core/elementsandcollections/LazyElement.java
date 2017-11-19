package core.elementsandcollections;


import core.conditions.Condition;
import org.openqa.selenium.WebElement;

import static core.ConciseAPI.getDriver;

public interface LazyElement extends LazyEntity<WebElement> {

    WebElement getWrappedEntity();

    LazyElement shouldBe(Condition<WebElement> condition);

}
