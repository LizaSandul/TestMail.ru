package sandul.liza.element;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import sandul.liza.driver.WebDriverSingleton;

import java.util.List;

public class Element {
    private String name;
    private By by;

    public Element(String name, By by) {
        this.name = name;
        this.by = by;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }

    public WebElement getWebElement() {
        return WebDriverSingleton.getInstance().findElement(by);
    }

    public void click() {
        getWebElement().click();
    }

    public String getText() {
        return getWebElement().getText();
    }

    public void type(String text) {
        WebElement element = getWebElement();
        element.clear();
        element.sendKeys(text);
    }

}