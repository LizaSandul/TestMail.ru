package sandul.liza.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import sandul.liza.driver.WebDriverSingleton;
import sandul.liza.web.elements.LoginElement;
import sandul.liza.web.elements.MailElement;

public class MailPage {

    public void typeTheme(String theme){
        MailElement.THEME.type(theme);
    }

    public void typeAddressee(String addressee){
        MailElement.ADDRESSEE.type(addressee);
    }

    public void clickMailButton(){
        MailElement.NEW_MAIL_BUTTON.click();
    }

    public void clickSendButton(){
        MailElement.SEND_BUTTON.click();
    }

    public void clickOkMessageButton(){
        MailElement.OK_BUTTON.click();
    }

    public String checkAddressee(){ return MailElement.CHECK_ADRESSEE.getText();}



}
