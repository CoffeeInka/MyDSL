package core.entities.element;


import core.conditions.Condition;
import org.openqa.selenium.*;

import java.util.List;

import static core.WaitFor.waitFor;
import static core.conditions.ElementConditions.present;
import static core.conditions.ElementConditions.visible;

public abstract class AbstractLazyElement implements LazyElement {

    public String identity() {
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

    public LazyElement setValue(String value) {
        this.shouldBe(visible());
        getWrappedEntity().clear();
        getWrappedEntity().sendKeys(value);
        return this;
    }

    public LazyElement pressEnter() {
        this.shouldBe(visible());
        getWrappedEntity().sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement $(By locator){
        return new LazyInnerElement(this, locator);
    }

    public LazyElement $(String innerSelector){
        return new LazyInnerElement(this, innerSelector);
    }

    @Override
    public boolean is(Condition<WebElement> condition) {
        try {
            if (condition.apply(this) != null) {
                return true;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return false;
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
        this.shouldBe(visible());
        getWrappedEntity().sendKeys(charSequences);
    }

    @Override
    public void clear() {
        this.shouldBe(visible());
        getWrappedEntity().clear();
    }

    @Override
    public String getTagName() {
        this.shouldBe(present());
        return getWrappedEntity().getTagName();
    }

    @Override
    public String getAttribute(String s) {
        this.shouldBe(present());
        return getWrappedEntity().getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        this.shouldBe(visible());
        return getWrappedEntity().isSelected();
    }

    @Override
    public boolean isEnabled() {
        this.shouldBe(visible());
        return getWrappedEntity().isEnabled();
    }

    @Override
    public String getText() {
        this.shouldBe(visible());
        return getWrappedEntity().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        this.shouldBe(visible());
        return getWrappedEntity().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        this.shouldBe(visible());
        return getWrappedEntity().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        this.shouldBe(present());
        return getWrappedEntity().isDisplayed();
    }

    @Override
    public Point getLocation() {
        this.shouldBe(visible());
        return getWrappedEntity().getLocation();
    }

    @Override
    public Dimension getSize() {
        this.shouldBe(visible());
        return getWrappedEntity().getSize();
    }

    @Override
    public Rectangle getRect() {
        this.shouldBe(visible());
        return getWrappedEntity().getRect();
    }

    @Override
    public String getCssValue(String s) {
        this.shouldBe(visible());
        return getWrappedEntity().getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return getWrappedEntity().getScreenshotAs(outputType);
    }

}
