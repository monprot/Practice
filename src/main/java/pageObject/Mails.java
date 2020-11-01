package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selBase.Base;

public class Mails extends Base {
    public String mailTheme1="Тестируем почту";
    public String mailText1="текст письма";
    public String mailSign="Я подпись подпись подпись, я вовсе не медведь";
    public String mailTheme2="Тестируем почту2";
    public String mailText2="текст письма2";

    public Mails(WebDriver driver) {
        super(driver);
    }

    @Step("Кликаем на создание нового письма")
    public void clickWriteMail() { click(".//a[@class='mail-ComposeButton js-main-action-compose']"); }

    @Step("Клик на 'себе' при отправке письма")
    public void clickSelfPost() { click(".//span[@data-name='Себе']"); }

    @Step("Ввод темы письма")
    public void setMailTheme(String theme) { setText("(.//input[@type='text'])[3]", theme); }

    @Step("Ввод текста письма")
    public void setMailText(String text) { setText(".//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']", text); }

    @Step("Кнопка отправки письма")
    public void clickSendMail() { click("(.//button[@data-nb='button'])[2]"); }

    @Step("Кликаем на входящие письма")
    public void clickInputsMail() { click(".//a[text()='Перейти во «Входящие».']"); }

    @Step("Кликаем кнопку оновить")
    public void clickRefresh() { click(".//span[@class='mail-ComposeButton-Refresh js-main-action-refresh ns-action']"); }

    @Step("Проверяем открытие формы отправки писем")
    public void assertOpenCompose(String text) {assertEquals("https://mail.yandex.ru/?uid=1198887252#compose",text);}

    @Step("кликаем на группу сообщений в списке сообщений")
    public void clickFindMail() { click("(.//span[@title='"+mailTheme1+"'])[1]"); }

    @Step("кликаем на сообщение в группе сообщений в списке сообщений")
    public void clickFindMail2() { click("(.//span[@title='"+mailText1+"'])[2]"); }

    @Step("кликаем на кнопку настроек")
    public void clickSettingButton() { click("(.//button[@data-lego='react'])[2]"); }

    @Step("кликаем на настройку личных данных")
    public  void clickLkSetButton() { click("(.//span[text()='Личные данные, подпись, портрет'])[2]"); }

    @Step("кликаем по группе сообщений с нужной темой")
    public void clickFindMail3() { click("(.//span[@title='"+mailTheme2+"'])[1]"); }

    @Step("кликаем на сообщений в группе сообщений")
    public void clickFindMail4() { click("(.//span[@title='"+mailText2+"'])[2]"); }
    //
    @Step("кликаем на кнопку входящие")
    public void clickInput() { click(".//span[text()='Входящие']"); }

    @Step("кликаем на чекбокс с темой 1")
    public void clickCheckMail1() { click("//span[@title='Тестируем почту']/ancestor::a//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']"); }

    @Step("Кликаем на чекбокс с темой 2")
    public void clickCheckMail2() { click("//span[@title='Тестируем почту2']/ancestor::a//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']"); }

    @Step("кликаем кнопку удаления писем")
    public void clickDeleteMails() { click(".//span[text()='Удалить']"); }

    @Step("Проверяем удаление письма с темой 1")
    public void checkDelMail() {
        Assert.assertFalse(isVisible(".//span[@title='"+mailTheme1+"']")); }

    @Step("Проверяем удаление письма с темой 2")
    public void checkDelMail2() {
        Assert.assertFalse(isVisible(".//span[@title='"+mailTheme2+"']")); }

    @Step("Проверяем удаление подписи")
    public void checkDelSign() {
       Assert.assertFalse(isVisible(".//div[contains(text(),'"+mailSign+"')]")); }

    @Step("Проверяем наличие письма с темой 1")
    public void assertMail1() { Assert.assertTrue(isVisible(".//span[@title='"+mailTheme1+"']")); }

    @Step("Проверяем наличие письма с темой 2")
    public void assertMail2() { Assert.assertTrue(isVisible(".//span[@title='"+mailTheme2+"']")); }

    @Step("Проверяем наличие подписи")
    public void assertSign() { Assert.assertTrue(isVisible(".//div[contains(text(),'"+mailSign+"')]")); }

    @Step("Проверяем соответствие темы и текста письма 1")
    public void assertMail1Content() {
        Assert.assertTrue(isVisible(".//div[text()='"+mailTheme1+"']"));
        Assert.assertTrue(isVisible(".//div[text()='"+mailText1+"']"));
    }
    @Step("Проверяем соответствие темы и текста письма 2")
    public void assertMail2Content() {
        Assert.assertTrue(isVisible(".//div[text()='"+mailTheme2+"']"));
        Assert.assertTrue(isVisible(".//div[text()='"+mailText2+"']"));
        Assert.assertTrue(isVisible(".//div[contains(text(),'"+mailSign+"')]"));
    }
}
