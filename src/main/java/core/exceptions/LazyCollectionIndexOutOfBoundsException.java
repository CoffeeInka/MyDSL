package core.exceptions;

import org.openqa.selenium.WebDriverException;

public class LazyCollectionIndexOutOfBoundsException extends WebDriverException {
    public LazyCollectionIndexOutOfBoundsException(String message) {
        super(message);
    }
}
