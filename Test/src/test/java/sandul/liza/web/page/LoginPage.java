package sandul.liza.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import sandul.liza.driver.WebDriverSingleton;
import sandul.liza.web.elements.LoginElement;

public class LoginPage {

    WebDriver driver =  WebDriverSingleton.getInstance();

    public void goToLoginPage(){
        driver.get(LoginElement.URL);
    }

    public void typeLogin(String login){
        LoginElement.LOGIN.type(login);
    }

    public void selectDomain(String value) {
        Select select = new Select(LoginElement.DOMAIN.getWebElement());
        select.selectByVisibleText(value);
    }

    public void typePassword(String password){
        LoginElement.PASSWORD.type(password);
    }

    public void clickLoginButton(){
        LoginElement.LOGIN_BUTTON.click();
    }

    public String getErrorMessage(){
        return LoginElement.LOGIN_ERROR.getText();
    }

    public String getLoginName(){ return LoginElement.USER_NAME.getText();}

}
