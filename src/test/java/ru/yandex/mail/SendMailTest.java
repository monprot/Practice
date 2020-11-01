package ru.yandex.mail;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageObject.Auth;
import pageObject.Mails;
import pageObject.Sign;

public class SendMailTest extends Settings{
    @Epic("Селениум")
    @Feature("Тест почты")
    @Story("Отправка писем")
    @Test
    void MailTest() throws InterruptedException {
        Auth auth = new Auth(getDriver());
        Mails in = new Mails(getDriver());
        Sign sign= new Sign(getDriver());

        /**
         * Авторизация
         */
        auth.clickInButton(); //кликаем на кнопку войти в почту
        auth.setLoginYand(auth.login + "\n"); //вводим логин
        auth.setPasswordYand(auth.pass + "\n"); //вводим пароль

        /**
         * Открываем окно отправки писем и проверяем его открытие
         */
        in.clickWriteMail(); //кликаем на кнопку "написать письмо"
        in.assertOpenCompose(getDriver().getCurrentUrl());

        /**
         * отправляем себе письмо
         */
        in.clickSelfPost();//выбор получателя письма "себе"
        in.setMailTheme(in.mailTheme1);//Ввод темы письма
        in.setMailText(in.mailText1);//Ввод текст письма
        in.clickSendMail();//нажать на кнопку отправить письмо

        /**
         * проверка пришло ли письмо
         */
        in.clickInputsMail();//нажать на кнопку входящие
        in.clickRefresh();//нажать на кнопку обновить
        Thread.sleep(1500);
        in.assertMail1();

        /**
         * открытие письма
         */
        Thread.sleep(1500);
        in.clickFindMail();
        Thread.sleep(1000);
        in.clickFindMail2();
        /**
         * проверка соответсвия темы и текста письма
         */
        Thread.sleep(1500);
        in.assertMail1Content();

        /**
         * Добавление подписи
         */
        in.clickSettingButton();
        in.clickLkSetButton();
        sign.clickSignText();
        sign.setSignText(in.mailSign);
        sign.clickSetSignButton();
        sign.clickLogo();



        /**
         * проверяем добавилась ли подпись
         */
        in.clickWriteMail(); //кликаем на кнопку "написать письмо"
        in.assertOpenCompose(getDriver().getCurrentUrl());
        Thread.sleep(1500);
        in.assertSign();

        /**
         * отправляем второе письмо
         */
        in.clickSelfPost();//выбор получателя письма "себе"
        in.setMailTheme(in.mailTheme2);//Ввод темы письма
        in.setMailText(in.mailText2);//Ввод текст письма
        in.clickSendMail();//нажать на кнопку отправить письмо

        /**
         * заходим во входящие и проверяем наличие письма с темой 2
         */
        in.clickInputsMail();//нажать на кнопку входящие
        in.clickRefresh();//нажать на кнопку обновить
        Thread.sleep(1500);
        in.assertMail2();

        /**
         * открываем письмо и проверяем соотсветствие темы, текста, подписи
         */
        Thread.sleep(2000);
        in.clickFindMail3();
        Thread.sleep(1000);
        in.clickFindMail4();
        Thread.sleep(1000);
        in.assertMail2Content();

        /**
         * Выбираем письма которые отправляем и удаляем
         */
        in.clickInput();
        in.clickRefresh();//нажать на кнопку обновить
        Thread.sleep(1000);
        in.clickCheckMail1(); //чекбокс сообщения с первой темой
        Thread.sleep(1000);
        in.clickCheckMail2(); //чекбокс сообщения со второй темой
        in.clickDeleteMails(); //клик кнопки удаления писем


        /**
         * Проверка что писем с такими темами нету
         */
        Thread.sleep(2000);
        in.checkDelMail();
        in.checkDelMail2();

        /**
         * удаляем созданную подпись
         */
        in.clickSettingButton();
        in.clickLkSetButton();
        sign.delSign();
        sign.delSignAccept();
        Thread.sleep(1000);

        /**
         * Проверяем что подписи нету
         */
        sign.clickLogo();
        in.clickWriteMail(); //кликаем на кнопку "написать письмо"
        in.assertOpenCompose(getDriver().getCurrentUrl());
        Thread.sleep(1000);
        in.checkDelSign();

    }
}
