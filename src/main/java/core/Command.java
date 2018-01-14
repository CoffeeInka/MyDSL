package core;

import core.entities.LazyElement;
import org.openqa.selenium.WebElement;

public interface Command<TypeOfResult> extends LazyElement {
    TypeOfResult execute(WebElement element);
}
