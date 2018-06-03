package sandul.liza.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import sandul.liza.driver.WebDriverSingleton;
import sandul.liza.helper.Helper;
import sandul.liza.web.page.LoginPage;
import sandul.liza.web.page.MailPage;

import java.io.IOException;

import static sandul.liza.helper.Helper.closeBrowser;

public class MailTest {

    WebDriver driver =  WebDriverSingleton.getInstance();
    private LoginPage lp = new LoginPage();
    private MailPage mp = new MailPage();

    public static final String ADDRESSEE = "gom.eee@mail.ru";
    public static final String SEVERAL_ADDRESSEE = "my.testing.2018@mail.ru";
    public static final String ERROR = "В поле «Кому» указан некорректный адрес получателя.\n" +
            "    Исправьте ошибку и отправьте письмо ещё раз.";


    String alertText = "";


    @Before
    public void init() throws InterruptedException {
        driver = WebDriverSingleton.getInstance();
        login();
    }

    public void login() {
        lp.goToLoginPage();
        lp.typeLogin("my.testing.2018");
        lp.selectDomain("@mail.ru");
        lp.typePassword("20Qwe18");
        lp.clickLoginButton();
    }

    @Test
    public void MailTest() {
        mp.clickMailButton();
        mp.typeAddressee(ADDRESSEE);
        mp.typeTheme("Test");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='10']")));
        WebElement body = driver.findElement(By.xpath("//body[@id='tinymce']"));
        body.clear();
        body.sendKeys("Hello");
        driver.switchTo().defaultContent();

        mp.clickSendButton();
        Helper.waitForTime(5);
        Assert.assertEquals(ADDRESSEE, mp.checkAddressee());
    }

    @Test
    public void mailForYourself() {
        mp.clickMailButton();
        mp.typeAddressee(SEVERAL_ADDRESSEE);
        mp.typeTheme("Test");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='10']")));
        WebElement body = driver.findElement(By.xpath("//body[@id='tinymce']"));
        body.clear();
        body.sendKeys("Hello");
        driver.switchTo().defaultContent();

        mp.clickSendButton();
        Helper.waitForTime(5);
        Assert.assertEquals(SEVERAL_ADDRESSEE, mp.checkAddressee());
    }

    @Test
    public void emptyTextMail() {
        mp.clickMailButton();
        mp.typeAddressee(ADDRESSEE);
        mp.typeTheme("Test");

        mp.clickSendButton();
        Helper.waitForTime(5);
        mp.clickOkMessageButton();
        Assert.assertEquals(ADDRESSEE, mp.checkAddressee());
    }

    @Test
    public void emptyAddressee() {
        mp.clickMailButton();
        mp.typeTheme("Test");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='10']")));
        WebElement body = driver.findElement(By.xpath("//body[@id='tinymce']"));
        body.clear();
        body.sendKeys("Hello");
        driver.switchTo().defaultContent();

        mp.clickSendButton();
        Helper.waitForTime(5);
        Alert alert = driver.switchTo().alert();
        alertText = alert.getText();
        alert.accept();
        Assert.assertEquals("Не указан адрес получателя", alertText);
    }

    @Test
    public void wrongAddressee() {
        mp.clickMailButton();
        mp.typeTheme("Test");
        mp.typeAddressee("ru");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='10']")));
        WebElement body = driver.findElement(By.xpath("//body[@id='tinymce']"));
        body.clear();
        body.sendKeys("Hello");
        driver.switchTo().defaultContent();

        mp.clickSendButton();
        Helper.waitForTime(5);
        Alert alert = driver.switchTo().alert();
        alertText = alert.getText();
        alert.accept();
        Assert.assertEquals(ERROR, alertText);
    }

    @After
    public void shutDown()throws IOException {
        closeBrowser();
    }
}

