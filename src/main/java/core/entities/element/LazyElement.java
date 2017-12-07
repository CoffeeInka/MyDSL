package core.entities.element;


import core.conditions.Condition;
import core.entities.LazyEntity;
import org.openqa.selenium.WebElement;

public interface LazyElement extends LazyEntity<WebElement> {

    LazyElement should(Condition<WebElement> condition);

    LazyElement shouldBe(Condition<WebElement> condition);

    LazyElement shouldHave(Condition<WebElement> condition);

    LazyElement setValue(String value);

    LazyElement click();

    LazyElement pressEnter();

}
