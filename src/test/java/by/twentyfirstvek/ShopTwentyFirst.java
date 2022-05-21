package by.twentyfirstvek;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class ShopTwentyFirst extends TestBase {

    @Order(2)
    @Test
    @DisplayName("Check Header 21Vek.by")
    void checkHeaderMainPage() {
        step("Open 21Vek.by page", () ->
                open(Configuration.baseUrl));
        step("Check Header", () -> {
            $("#header").shouldHave(
                    text("г. Минск"),
                    text("Оплата частями"),
                    text("Бонусная программа"),
                    text("Еще"));
        });
    }

    @Test
    @DisplayName("Check Footer 21Vek.by")
    void checkFooterMainPage() {
        step("Open 21Vek.by page", () ->
                open(Configuration.baseUrl));
        step("Check Footer", () -> {
            $("#footer-inner").shouldHave(
                    text("Покупателям"),
                    text("Доставка"),
                    text("Обработка персональных данных"),
                    text("Оплата"));
        });
    }

    @Test
    @DisplayName("Check Search Function 21Vek.by")
    void checkSearchFunction() {
        step("Open 21Vek.by page", () ->
                open(Configuration.baseUrl));
        step("Check Search Function", () -> {
            $("#catalogSearch").setValue("Детские коляски").pressEnter();
            sleep(7000);
            $(".content__header.cr-category_header").shouldHave(text("Результаты поиска"), Duration.ofSeconds(10));
        });
    }


    @Order(1)
    @Test
    @DisplayName("Check Authorization Function 21Vek.by")
    void checkAuthorizationFunction() {
        step("Open 21Vek.by page", () ->
                open(Configuration.baseUrl));
        step("Check Authorization ", () -> {
            $(".userToolsText").click();
            $(".userToolsBtn").click();
            $("#login-email").setValue(config.login1());
            $("#login-password").setValue(config.password1()).pressEnter();
            sleep(8000);
            $(".userToolsText").click();
            $(".userToolsSubtitle").shouldHave(text("888chelovek888@gmail.com"));
        });
    }
    @Test
    @DisplayName("Check Grass cuts 21Vek.by")
    void checkGrassCuts () {
        step("Open 21Vek.by page", () ->
                open(Configuration.baseUrl));
        step("Check Grass cuts ", () -> {
            $(byText("Газонокосилки")).click();
            $(".content__header.cr-category_header").shouldHave(text("Газонокосилки"));
        });
    }
}

