package core.conditions.element;


import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Text extends ElementCondition {

    private String expectedText;
    private String actualText;

    public Text(String expectedText) {
        this.expectedText = expectedText;
    }

    @Override
    public boolean check(WebElement element) {
        actualText = element.getText();
        return (actualText.contains(expectedText));
    }

    @Override
    public String expected() {
        return expectedText;
    }

    @Override
    public String actual() {
        return actualText;
    }
}
