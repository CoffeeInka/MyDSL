package core.conditions.element;

import org.openqa.selenium.WebElement;

public class ExactText extends Text {

    public ExactText(String expectedText) {
        super(expectedText);
    }

    @Override
    public boolean check(WebElement element) {
        actualText = element.getText();
        return (actualText.equals(expectedText));
    }

}
