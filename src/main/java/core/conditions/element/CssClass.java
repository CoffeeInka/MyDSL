package core.conditions.element;

import core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class CssClass extends AbstractCondition<WebElement> {

    private String className;

    private String actualCssClassNames;

    public CssClass(String className) {
        this.className = className;

    }


    @Override
    public boolean check(WebElement entity) {
        actualCssClassNames = entity.getAttribute("class");
        return Arrays.asList(actualCssClassNames.split(" ")).contains(className);
    }

    @Override
    public String expected() {
        return className;
    }

    @Override
    public String actual() {
        return actualCssClassNames;
    }
}
