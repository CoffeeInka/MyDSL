package core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Element extends Elements {

    public Element(By locator){
    }

    @Override
    public WebElement getWrappedEntity() {
        return null;
    }

    @Override
    public WebElement shouldBe() {
        return null;
    }

}
