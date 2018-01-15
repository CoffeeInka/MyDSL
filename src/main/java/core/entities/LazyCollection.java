package core.entities;


import core.conditions.Condition;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface LazyCollection extends LazyEntity<List<WebElement>>, Iterable<LazyElement> {

    LazyCollection should(Condition<List<WebElement>> condition);

    LazyCollection shouldBe(Condition<List<WebElement>> condition);

    LazyCollection shouldHave(Condition<List<WebElement>> condition);

    LazyElement get(int index);

    LazyCollection filter(Condition<WebElement> condition);

    LazyElement find(Condition<WebElement> condition);

}
