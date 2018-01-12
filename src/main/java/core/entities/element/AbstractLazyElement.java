package core.entities.element;


import core.Command;
import core.WithWaitFor;
import core.exceptions.ElementNotFoundException;
import core.conditions.Condition;
import core.entities.LazyCollection;
import core.entities.LazyElement;
import core.entities.collection.LazyElementInnerCollection;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static core.ConciseAPI.getDriver;
import static core.WaitFor.waitFor;
import static core.conditions.ElementConditions.present;
import static core.conditions.ElementConditions.visible;

public abstract class AbstractLazyElement implements LazyElement {

    public abstract WebElement fetchWrappedEntity();

    public WebElement getWrappedEntity() {
        WebElement wrappedEntity = fetchWrappedEntity();
        if (wrappedEntity == null) {
            throw new ElementNotFoundException(toString());
        }
        return wrappedEntity;
    }

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
        this.shouldBe(visible())
                .getWrappedEntity().clear();
        getWrappedEntity().sendKeys(value);
        return this;
    }

    public LazyElement pressEnter() {
        this.shouldBe(visible())
                .getWrappedEntity().sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement $(By locator) {
        return new LazyElementInnerElement(this, locator);
    }

    public LazyElement $(String innerSelector) {
        return new LazyElementInnerElement(this, By.cssSelector(innerSelector));
    }

    public LazyCollection findAll(By innerLocator) {
        return new LazyElementInnerCollection(this, innerLocator);
    }

    public LazyCollection findAll(String innerCssSelector) {
        return new LazyElementInnerCollection(this, By.cssSelector(innerCssSelector));
    }

    @Override
    public LazyElement hover() {
        this.shouldBe(visible());
        Actions actions = new Actions(getDriver());
        actions.moveToElement(this.getWrappedEntity()).perform();
        return this;
    }

    @Override
    public boolean is(Condition<WebElement> condition) {
        try {
            return condition.check(getWrappedEntity());
        } catch (WebDriverException e) {
            return false;
        }
    }

    @Override
    public void click() {
        this.shouldBe(visible())
                .getWrappedEntity().click();
    }

    @Override
    public LazyElement doubleClick() {
        this.shouldBe(visible());
        Actions actions = new Actions(getDriver());
        actions.doubleClick(this.getWrappedEntity()).perform();
        return this;
    }

    @Override
    public void submit() {
        this.shouldBe(visible())
                .getWrappedEntity().submit();
    }

    @Override
//    public void sendKeys(CharSequence... charSequences) {
//        this.shouldBe(visible())
//                .getWrappedEntity().sendKeys(charSequences);
//    }
    public void sendKeys(final CharSequence... charSequences) {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.sendKeys(charSequences);
                return element;
            }
        });
    }

    @Override
    public void clear() {
        this.shouldBe(visible())
                .getWrappedEntity().clear();
    }

    @Override
    public String getTagName() {
        return this.shouldBe(present())
                .getWrappedEntity().getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return this.shouldBe(present())
                .getWrappedEntity().getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return this.shouldBe(visible())
                .getWrappedEntity().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return this.shouldBe(visible())
                .getWrappedEntity().isEnabled();
    }

    @Override
    public String getText() {
        return this.shouldBe(visible())
                .getWrappedEntity().getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.shouldBe(visible())
                .getWrappedEntity().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.shouldBe(visible())
                .getWrappedEntity().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return this.shouldBe(present())
                .getWrappedEntity().isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.shouldBe(visible())
                .getWrappedEntity().getLocation();
    }

    @Override
    public Dimension getSize() {
        return this.shouldBe(visible())
                .getWrappedEntity().getSize();
    }

    @Override
    public Rectangle getRect() {
        return this.shouldBe(visible())
                .getWrappedEntity().getRect();
    }

    @Override
    public String getCssValue(String s) {
        return getWrappedEntity().getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return getWrappedEntity().getScreenshotAs(outputType);
    }

}
