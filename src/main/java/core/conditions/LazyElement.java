package core.conditions;


import org.openqa.selenium.WebElement;

public interface LazyElement<T> extends LazyEntity<WebElement> {

    T shouldBe();

}
