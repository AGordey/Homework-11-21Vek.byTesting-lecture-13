package by.twentyfirstvek;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class TestingFormTests extends TestBase {

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

    @Test
    @DisplayName("Check Authorization Function 21Vek.by")
    void checkAuthorizationFunction() {
        step("Open 21Vek.by page", () ->
                open(Configuration.baseUrl));
        step("Check Authorization ", () -> {
            $(byText("Аккаунт")).click();
            $(".userToolsBtn").click();
            $("#login-email").setValue("888chelovek888@gmail.com");
            $("#login-password").setValue("jndthnrf").pressEnter();
            $(byText("Аккаунт")).click();
            $(".userToolsSubtitle").shouldHave(text("888chelovek888@gmail.com"));
        });

    }
}

