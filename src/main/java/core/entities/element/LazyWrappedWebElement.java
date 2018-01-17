package core.entities.element;

import org.openqa.selenium.WebElement;


public class LazyWrappedWebElement extends AbstractLazyElement {

    private WebElement element;

    public LazyWrappedWebElement(WebElement element) {
        this.element = element;
    }

    @Override
    public WebElement fetchWrappedEntity() {
        return this.element;
    }

    @Override
    public String toString() {
        return "Wrapped element " + element;
    }

}
