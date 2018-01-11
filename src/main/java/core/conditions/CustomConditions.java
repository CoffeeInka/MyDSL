package core.conditions;

import core.Configuration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.ConciseAPI.getDriver;

public class CustomConditions {

    public static ExpectedCondition<Boolean> jsReturnedTrue(final String script, final Object... arguments) {

        return new ExpectedCondition<Boolean>() {
            Object result;

            public Boolean apply(WebDriver webDriver) {
                try {
                    this.result = ((JavascriptExecutor) webDriver).executeScript(script, arguments);
                    return (Boolean) this.result;
                } catch (Exception e) {
                    return false;
                }
            }

            public String toString() {
                return String.format(
                        "expected script: %s\n" +
                                "to return: true\n" +
                                "but returned: %s\n",
                        script, this.result
                );
            }
        };
    }
}
