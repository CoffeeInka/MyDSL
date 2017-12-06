package core.entities;


import core.conditions.Condition;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface LazyCollection extends LazyEntity<List<WebElement>> {

    LazyCollection should(Condition<List<WebElement>> condition);

    LazyCollection shouldBe(Condition<List<WebElement>> condition);

    LazyCollection shouldHave(Condition<List<WebElement>> condition);

}
