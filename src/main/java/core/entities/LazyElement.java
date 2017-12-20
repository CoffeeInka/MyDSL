package core.entities;


import core.conditions.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface LazyElement extends LazyEntity<WebElement>, WebElement {

    LazyElement should(Condition<WebElement> condition);

    LazyElement shouldBe(Condition<WebElement> condition);

    LazyElement shouldHave(Condition<WebElement> condition);

    LazyElement setValue(String value);

    LazyElement pressEnter();

    LazyElement $(By locator);

    LazyElement $(String innerSelector);

    void hover(LazyElement element);

    boolean is(Condition<WebElement> condition);

    LazyCollection findAll(By innerLocator);

    LazyCollection findAll(String innerCssSelector);

//    void hover();
}

