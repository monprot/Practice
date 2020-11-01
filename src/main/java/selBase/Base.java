package selBase;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Base {
    private WebDriver driver;

    protected final int driverWaitTime = 20;

    public Base(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }


    /**
     * Ждем пока элемент отобразится на странице.
     * Метод возвращает Boolean.
     *
     * @param element
     * @return
     */
    protected Boolean waitVisibilityOfElement(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, driverWaitTime);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    protected Boolean waitPresentOfElement(final String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, driverWaitTime);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Метод ждет появления элемента по xpath.
     * Ищет элемент через findElement.
     * Кликает по элементу.
     *
     * @param xpath
     */
    protected void click(final String xpath) {
        waitPresentOfElement(xpath);
        WebElement webElement = getDriver().findElement(By.xpath(xpath));
        waitVisibilityOfElement(webElement);
        webElement.click();
    }

    protected void setText(final String xpath, final String string) {
        waitPresentOfElement(xpath);
        WebElement webElement = getDriver().findElement(By.xpath(xpath));
        waitVisibilityOfElement(webElement);
        webElement.sendKeys(string);
    }
    protected void assertEquals(final String xpath, final String string) {
        Assert.assertEquals(string, xpath);
    }
    protected void moveMouse(final String xpath) {
        waitPresentOfElement(xpath);
        WebElement webElement = getDriver().findElement(By.xpath(xpath));
        waitVisibilityOfElement(webElement);
        Actions action = new Actions(driver);
        action.moveToElement(webElement);
        action.perform();
    }

    /**
     * Проверяет что элемент не найден
     * @param xpath
     * @return
     */
      public boolean isVisible(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).isDisplayed();
            return true;

        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }


    }

}
