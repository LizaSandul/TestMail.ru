package sandul.liza.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import sandul.liza.driver.WebDriverSingleton;
import sandul.liza.helper.Helper;
import sandul.liza.web.page.LoginPage;

import java.io.IOException;

import static sandul.liza.helper.Helper.closeBrowser;

public class LoginTest {

    private WebDriver driver = WebDriverSingleton.getInstance();
    private LoginPage lp = new LoginPage();

    @Before
    public void init() throws InterruptedException {
        driver = WebDriverSingleton.getInstance();
    }

    @Test
    public void checkLogin() {
        lp.goToLoginPage();
        lp.typeLogin("my.testing.2018");
        lp.selectDomain("@mail.ru");
        lp.typePassword("20Qwe18");
        lp.clickLoginButton();
        Helper.waitForTime(5);
        Assert.assertEquals("my.testing.2018@mail.ru",lp.getLoginName());
    }

    @Test
    public void passwordEmpty() {
        lp.goToLoginPage();
        lp.typeLogin("my.testing.2018");
        lp.selectDomain("@mail.ru");
        lp.clickLoginButton();
        Helper.waitForTime(5);
        Assert.assertEquals("Введите пароль",lp.getErrorMessage());
    }

    @Test
    public void loginEmpty() {
        lp.goToLoginPage();
        lp.selectDomain("@mail.ru");
        lp.typePassword("20Qwe18");
        lp.clickLoginButton();
        Helper.waitForTime(5);
        Assert.assertEquals("Введите имя ящика",lp.getErrorMessage());
    }

    @Test
    public void pusswordRussian() {
        lp.goToLoginPage();
        lp.typeLogin("my.testing.2018");
        lp.selectDomain("@mail.ru");
        lp.typePassword("20Йцу18");
        lp.clickLoginButton();
        Helper.waitForTime(5);
        Assert.assertEquals("Неверное имя или пароль",lp.getErrorMessage());
    }

    @Test
    public void negativeLogin() {
        lp.goToLoginPage();
        lp.typeLogin("my.testing.2017");
        lp.selectDomain("@mail.ru");
        lp.typePassword("20Qwe18");
        lp.clickLoginButton();
        Helper.waitForTime(5);
        Assert.assertEquals("Неверное имя или пароль",lp.getErrorMessage());
    }

    @Test
    public void spaceLogin() {
        lp.goToLoginPage();
        lp.typeLogin("  my.testing.2018");
        lp.selectDomain("@mail.ru");
        lp.typePassword("20Qwe18");
        lp.clickLoginButton();
        Helper.waitForTime(5);
        Assert.assertEquals("Неверное имя ящика",lp.getErrorMessage());
    }

    @Test
    public void CapsLogin() {
        lp.goToLoginPage();
        lp.typeLogin("MY.TESTING.2018");
        lp.selectDomain("@mail.ru");
        lp.typePassword("20Qwe18");
        lp.clickLoginButton();
        Helper.waitForTime(5);
        Assert.assertEquals("my.testing.2018@mail.ru",lp.getLoginName());
    }

    @Test
    public void CapsPassword() {
        lp.goToLoginPage();
        lp.typeLogin("my.testing.2018");
        lp.selectDomain("@mail.ru");
        lp.typePassword("20QWE18");
        lp.clickLoginButton();
        Helper.waitForTime(5);
        Assert.assertEquals("Неверное имя или пароль",lp.getErrorMessage());
    }

    @After
    public void shutDown()throws IOException {
        closeBrowser();
    }
}
