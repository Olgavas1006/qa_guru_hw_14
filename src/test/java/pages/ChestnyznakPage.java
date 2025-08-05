package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ChestnyznakPage {

    private SelenideElement padding() { return $(".padding"); }
    private SelenideElement autoLink() { return $("a[href='/auto']"); }
    private SelenideElement companiesLink() { return $("a[href='/for-companies']"); }
    private SelenideElement faqButton() { return $(".button-faq"); }
    private SelenideElement supportMenuLink() { return $("li.item.mobileHidden.text--menu-item-bold > a"); }
    private SelenideElement authLink() { return $("a[href='/authorization']"); }


    public ChestnyznakPage openPage() {
        Selenide.open("https://www.rgs.ru/");
        return this;
    }

    public ChestnyznakPage clickPadding() {
        padding().click();
        return this;
    }

    public ChestnyznakPage navigateToAutoInsurance() {
        autoLink().click();
        return this;
    }

    public ChestnyznakPage verifyAutoInsuranceHeaderVisible() {
        $(byText("Автострахование")).shouldBe(visible);
        return this;
    }

    public ChestnyznakPage navigateToCompaniesSection() {
        companiesLink().click();
        return this;
    }

    public ChestnyznakPage verifyCompaniesCategories(String expectedText) {
        $(".category").shouldHave(text(expectedText));
        return this;
    }

    public ChestnyznakPage openFaqSection() {
        faqButton().click();
        return this;
    }

    public ChestnyznakPage selectCity(String cityName) {
        $(".grid").shouldHave(text(cityName)).click();
        return this;
    }

    public ChestnyznakPage openSupportMenu() {
        supportMenuLink().click();
        return this;
    }

    public ChestnyznakPage navigateToFaq() {
        $("a[href='/faq']").click();
        return this;
    }

    public ChestnyznakPage verifySupportHeader() {
        $(".page-content").shouldHave(text("Центр поддержки клиентов — отвечаем на ваши вопросы"));
        return this;
    }

    public ChestnyznakPage openAuthorizationPage() {
        authLink().click();
        return this;
    }

    public ChestnyznakPage verifyAuthHeader() {
        $("h2.section-basic__title").shouldHave(text("Вход в личный кабинет"));
        return this;
    }

    public ChestnyznakPage openPersonalAccount() {
        $("a[aria-label='Личный кабинет клиента']")
                .shouldHave(attribute("href", "https://lk.rgs.ru/"))
                .click();
        return this;
    }

    public ChestnyznakPage enterPhoneNumber(String phone) {
        $("[name='phoneNumber']").setValue(phone);
        return this;
    }
}
