package core.entities.element;


import core.Command;
import core.WithWaitFor;
import core.conditions.Condition;
import core.entities.LazyCollection;
import core.entities.LazyElement;
import core.entities.collection.LazyElementInnerCollection;
import core.exceptions.ElementNotFoundException;
import org.openqa.selenium.*;

import java.util.List;

import static com.herokuapp.pages.ToDoMVC.actions;
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

    public LazyElement $(By locator) {
        return new LazyElementInnerElement(this, locator);
    }

    public LazyElement $(String innerSelector) {
        return this.$(By.cssSelector(innerSelector));
    }

    public LazyCollection findAll(By innerLocator) {
        return new LazyElementInnerCollection(this, innerLocator);
    }

    public LazyCollection findAll(String innerCssSelector) {
        return this.findAll(By.cssSelector(innerCssSelector));
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

    @Override
    public boolean is(Condition<WebElement> condition) {
        try {
            return condition.check(getWrappedEntity());
        } catch (WebDriverException e) {
            return false;
        }
    }

    @Override
    public LazyElement setValue(String value) {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                element.clear();
                element.sendKeys(value);
                return element;
            }
        });
        return this;
    }

    @Override
    public LazyElement pressEnter() {
        this.sendKeys(Keys.ENTER);
        return this;
    }

    @Override
    public LazyElement pressEscape() {
        this.sendKeys(Keys.ESCAPE);
        return this;
    }

    @Override
    public LazyElement doubleClick() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                actions().doubleClick(element).perform();
                return element;
            }
        });
        return this;
    }

    @Override
    public LazyElement hover() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                actions().moveToElement(element).perform();
                return element;
            }
        });
        return this;
    }

    @Override
    public void click() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                element.click();
                return element;
            }
        });
    }

    @Override
    public void submit() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                element.submit();
                return element;
            }
        });
    }

    @Override
    public void sendKeys(final CharSequence... charSequences) {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                element.sendKeys(charSequences);
                return element;
            }
        });
    }

    @Override
    public void clear() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                element.clear();
                return element;
            }
        });
    }

    @Override
    public String getTagName() {
        return new WithWaitFor(this, present()).run(new Command<String>() {
            @Override
            public String execute(WebElement element) {
                return element.getTagName();
            }
        });
    }

    @Override
    public String getAttribute(String name) {
        return new WithWaitFor(this, present()).run(new Command<String>() {
            @Override
            public String execute(WebElement element) {
                return element.getAttribute(name);
            }
        });
    }

    @Override
    public String getText() {
        return new WithWaitFor(this, visible()).run(new Command<String>() {
            @Override
            public String execute(WebElement element) {
                return element.getText();
            }
        });
    }

    @Override
    public boolean isSelected() {
        return new WithWaitFor(this, visible()).run(new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isSelected();
            }
        });
    }

    @Override
    public boolean isEnabled() {
        return new WithWaitFor(this, visible()).run(new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isEnabled();
            }
        });
    }

    @Override
    public boolean isDisplayed() {
        return new WithWaitFor(this, present()).run(new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isDisplayed();
            }
        });
    }

    @Override
    public Point getLocation() {
        return new WithWaitFor(this, visible()).run(new Command<Point>() {
            @Override
            public Point execute(WebElement element) {
                return element.getLocation();
            }
        });
    }

    @Override
    public Dimension getSize() {
        return new WithWaitFor(this, visible()).run(new Command<Dimension>() {
            @Override
            public Dimension execute(WebElement element) {
                return element.getSize();
            }
        });
    }

    @Override
    public Rectangle getRect() {
        return new WithWaitFor(this, visible()).run(new Command<Rectangle>() {
            @Override
            public Rectangle execute(WebElement element) {
                return element.getRect();
            }
        });
    }

    @Override
    public String getCssValue(String s) {
        return new WithWaitFor(this, present()).run(new Command<String>() {
            @Override
            public String execute(WebElement element) {
                return getWrappedEntity().getCssValue(s);
            }
        });
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return new WithWaitFor(this, visible()).run(new Command<X>() {
            @Override
            public X execute(WebElement element) {
                return getWrappedEntity().getScreenshotAs(outputType);
            }
        });
    }

    @Override
    public List<WebElement> findElements(By by) {
        return new WithWaitFor(this, visible()).run(new Command<List<WebElement>>() {
            @Override
            public List<WebElement> execute(WebElement element) {
                return element.findElements(by);
            }
        });
    }


    @Override
    public WebElement findElement(By by) {
        return new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement execute(WebElement element) {
                return element.findElement(by);
            }
        });
    }

}
