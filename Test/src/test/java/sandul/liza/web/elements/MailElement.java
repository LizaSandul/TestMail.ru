package sandul.liza.web.elements;

import org.openqa.selenium.By;
import sandul.liza.element.Element;

public class MailElement {

        public static final Element NEW_MAIL_BUTTON =  new Element("Кнопка написать письмо",By.xpath("//a//span[contains(text(),'Написать письмо')]"));
        public static final Element THEME =  new Element("Тема письма",By.xpath("//input[@tabindex='7']"));
        public static final Element ADDRESSEE =  new Element("Получаетель",By.xpath("//textarea[@tabindex='4']"));
        public static final Element SEND_BUTTON =  new Element("Кнопка отправить",By.xpath("//div[@data-name='send']//span[contains(text(),'Отправить')]"));
        public static final Element CHECK_ADRESSEE =  new Element("Проверка получателя",By.xpath("//div//span[@class='message-sent__info']"));
        public static final Element OK_BUTTON =  new Element("Кнопка Ок",By.xpath("//div[@class='is-compose-empty_in']//button[@type='submit']"));


}
