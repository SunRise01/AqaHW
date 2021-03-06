package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {

    private WebDriverWait wait =  new WebDriverWait(DriverFactory.getDriver(), 10);

    AbstractPage() {
    }

    void  proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

     WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    List<WebElement> getElements(String locator) {
        return DriverFactory.getDriver().findElements(By.xpath(locator));
    }


    public boolean isDisplayed(By locator) {
        try {
            return getElement(locator)
                  .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isEnabled(By locator) {
        try {
            return getElement(locator)
                    .isEnabled();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


}
