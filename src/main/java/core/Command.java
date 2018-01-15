package core;

import core.entities.LazyElement;
import org.openqa.selenium.WebElement;

public interface Command<TypeOfResult> {
    TypeOfResult execute(WebElement element);
}
