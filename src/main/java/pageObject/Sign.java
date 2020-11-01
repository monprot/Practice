package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import selBase.Base;

public class Sign extends Base {

    public Sign(WebDriver driver) {
        super(driver);
    }

    @Step("Клик в поле воода подписи")
    public void clickSignText() { click(".//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']"); }

    @Step("Ввод текста подписи")
    public void setSignText(String text) {
        setText(".//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']", text) ;
    }

    @Step("кликаем кнопку добавления подписи")
    public void clickSetSignButton() { click(".//span[@class='ui-button-text']"); }

    @Step("кликаем на логотип яндекс почты")
    public void clickLogo() { click(".//a[@class='yandex-header__logo-service yandex-header__logo-service_lang_ru count-me']"); }

    //public void moveDelSign() {moveMouse("(//div[@class='b-form-element__signature__text js-setup-signature-text'])[1]");}
    @Step("Удаляем последнию подпись")
    public void delSign() {
        moveMouse("(//div[@class='b-form-element__signature__text js-setup-signature-text'])[1]");
        click("(//div[@title='Удалить'])[1]"); }

    @Step("Подтверждаем удаление подписи")
    public void delSignAccept() { click("//span[text()='Удалить']"); }
}
