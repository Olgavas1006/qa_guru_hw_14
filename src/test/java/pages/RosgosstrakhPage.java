package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RosgosstrakhPage {

    private final SelenideElement autoLink = $("a[href='/auto']"),
            companiesLink = $("a[href='/for-companies']"),
            faqButton = $(".button-faq"),
            supportMenuLink = $("li.item.mobileHidden.text--menu-item-bold > a"),
            authLink = $("a[href='/authorization']");

    public RosgosstrakhPage openPage() {
        Selenide.open("https://www.rgs.ru/");
        return this;
    }

    public RosgosstrakhPage clickPadding() {
        $(".padding").click();
        return this;
    }

    public RosgosstrakhPage navigateToAutoInsurance() {
        autoLink.click();
        return this;
    }

    public RosgosstrakhPage verifyAutoInsuranceHeaderVisible() {
        $(byText("Автострахование")).shouldBe(visible);
        return this;
    }

    public RosgosstrakhPage navigateToCompaniesSection() {
        companiesLink.click();
        return this;
    }

    public RosgosstrakhPage verifyCompaniesCategories(String expectedText) {
        $(".category").shouldHave(text(expectedText));
        return this;
    }

    public RosgosstrakhPage openFaqSection() {
        faqButton.click();
        return this;
    }

    public RosgosstrakhPage selectCity(String cityName) {
        $(".grid").shouldHave(text(cityName)).click();
        return this;
    }

    public RosgosstrakhPage openSupportMenu() {
        supportMenuLink.click();
        return this;
    }

    public RosgosstrakhPage navigateToFaq() {
        $("a[href='/faq']").click();
        return this;
    }

    public RosgosstrakhPage verifySupportHeader() {
        $(".page-content").shouldHave(text("Центр поддержки клиентов — отвечаем на ваши вопросы"));
        return this;
    }

    public RosgosstrakhPage openAuthorizationPage() {
        authLink.click();
        return this;
    }

    public RosgosstrakhPage verifyAuthHeader() {
        $("h2.section-basic__title").shouldHave(text("Вход в личный кабинет"));
        return this;
    }

    public RosgosstrakhPage openPersonalAccount() {
        $(".card-content")
                .shouldHave(text("Личный кабинет клиента"))
                .click();
        return this;
    }

    public RosgosstrakhPage enterPhoneNumber(String phone) {
        $("[name='phoneNumber']").setValue(phone);
        return this;
    }
}
