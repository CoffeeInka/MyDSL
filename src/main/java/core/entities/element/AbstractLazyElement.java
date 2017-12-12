package core.entities.element;


import core.conditions.Condition;
import org.openqa.selenium.*;

import java.util.List;

import static core.WaitFor.waitFor;
import static core.conditions.ElementConditions.present;
import static core.conditions.ElementConditions.visible;

public abstract class AbstractLazyElement implements LazyElement {

    public String identity(){
        return "Element";
    }

    public LazyElement should(Condition<WebElement> condition) {
        waitFor(this).until(condition);
        return this;
    }

    public LazyElement shouldBe(Condition<WebElement> condition) {
        return this.should(condition);
    }

    public LazyElement shouldHave(Condition<WebElement> condition) {
        return this.should(condition);
    }

    public LazyElement setValue(String value){
        this.shouldBe(visible());
        getWrappedEntity().clear();
        getWrappedEntity().sendKeys(value);
        return this;
    }

    public LazyElement pressEnter(){
        this.shouldBe(visible());
        getWrappedEntity().sendKeys(Keys.ENTER);
        return this;
    }

    @Override
    public void click() {
        this.shouldBe(visible());
        getWrappedEntity().click();
    }

    @Override
    public void submit() {
        this.shouldBe(visible());
        getWrappedEntity().submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        //present
        return null;
    }

    @Override
    public String getAttribute(String s) {
        //present
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        //present
        this.shouldBe(present());
        return this.getWrappedEntity().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

}
