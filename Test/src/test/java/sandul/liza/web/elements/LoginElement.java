package sandul.liza.web.elements;

import org.openqa.selenium.By;
import sandul.liza.element.Element;

public class LoginElement {

        public static final String URL = "http://mail.ru/";

        public static final Element LOGIN = new Element ("Логин пользователя", By.xpath("//input[@id='mailbox:login']"));
        public static final Element DOMAIN = new Element("Домен", By.xpath("//select[@id='mailbox:domain']")) ;
        public static final Element PASSWORD = new Element("Пароль", By.xpath("//input[@id='mailbox:password']"));
        public static final Element LOGIN_BUTTON = new Element("Кнопка входа", By.xpath("//input[@value='Войти']")) ;
        public static final Element USER_NAME = new Element("Почта пользователя", By.xpath("//i[@id='PH_user-email']")) ;
        public static final Element LOGIN_ERROR = new Element("Ошибка входа", By.xpath("//div[@id='mailbox:error']")) ;

}
