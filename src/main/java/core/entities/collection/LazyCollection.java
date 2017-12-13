package core.entities.collection;


import core.conditions.Condition;
import core.entities.LazyEntity;
import core.entities.element.LazyElement;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface LazyCollection extends LazyEntity<List<WebElement>>, Iterable<LazyElement>{

    LazyCollection should(Condition<List<WebElement>> condition);

    LazyCollection shouldBe(Condition<List<WebElement>> condition);

    LazyCollection shouldHave(Condition<List<WebElement>> condition);

    LazyElement get(int index);

    LazyCollection filter(Condition<WebElement> condition);

    LazyElement find(Condition<WebElement> condition);

}
