package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import selBase.Base;

public class Auth extends Base {
    public String login="testimmailauto";
    public String pass="1029384756";
    public Auth(WebDriver driver) {
        super(driver);
    }

    @Step("Кликаем на кнопку войти в яндекс почту")
    public void clickInButton() { click(".//a[@class = 'button2 button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']"); }

    @Step("Вводим логин в поле логина")
    public void setLoginYand(String login) { setText("//*[@id='passp-field-login']", login); }

    @Step("Вводим пароль в поле пароля")
    public void setPasswordYand(String pass) { setText("//*[@id='passp-field-passwd']", pass); }
}
