package core.entities;


import core.conditions.Condition;
import org.openqa.selenium.WebElement;

public interface LazyElement extends LazyEntity<WebElement> {

    LazyElement shouldBe(Condition<WebElement> condition);

}
