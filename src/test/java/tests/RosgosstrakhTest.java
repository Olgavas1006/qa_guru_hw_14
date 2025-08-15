package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RosgosstrakhPage;
import static io.qameta.allure.Allure.step;

class RosgosstrakhTest extends TestBase {

    RosgosstrakhPage page = new RosgosstrakhPage();

    @Test
    @DisplayName("Проверка перехода на страницу автострахования")
    void checkAutoPageTest() {
        step("Открыть главную страницу", () ->
                page.openPage());
        step("Нажать на Авто", () ->
                page.clickPadding());
        step("Перейти в раздел Авто", () ->
                page.navigateToAutoInsurance());
        step("Проверить видимость заголовка 'Автострахование'", () ->
                page.verifyAutoInsuranceHeaderVisible());
    }


    @Test
    @DisplayName("Проверка раздела 'Для компаний' и категорий страхования")
    void checkForCompaniesTest() {
        step("Открыть главную страницу", () ->
                page.openPage());
        step("Перейти в раздел 'Для компаний'", () ->
                page.navigateToCompaniesSection());
        step("Проверить отображение всех категорий страхования", () ->
                page.verifyCompaniesCategories("Автострахование Здоровье Имущество Ответственность " +
                        "Транспорт/Перевозки Отраслевые продукты Перестрахование Строительство"));
    }

    @Test
    @DisplayName("Выбор города в разделе FAQ")
    void cityTest() {
        step("Открыть главную страницу", () ->
                page.openPage());
        step("Открыть раздел FAQ", () ->
                page.openFaqSection());
        step("Выбрать город Уфа", () ->
                page.selectCity("Уфа"));
    }

    @Test
    @DisplayName("Проверка раздела поддержки клиентов")
    void supportTest() {
        step("Открыть главную страницу", () ->
                page.openPage());
        step("Открыть меню поддержки", () ->
                page.openSupportMenu());
        step("Перейти в раздел FAQ", () ->
                page.navigateToFaq());
        step("Проверить заголовок раздела поддержки", () ->
                page.verifySupportHeader());
    }

    @Test
    @DisplayName ("Проверка перехода в личный кабинет и ввода номера телефона")
    void personalAccountTest() {
        step("Открыть главную страницу", () ->
                page.openPage());
        step("Перейти на страницу авторизации", () ->
                page.openAuthorizationPage());
        step("Проверить заголовок 'Вход в личный кабинет'", () ->
                page.verifyAuthHeader());
        step("Перейти в личный кабинет", () ->
                page.openPersonalAccount());
        step("Ввести номер телефона 9991234567", () ->
                page.enterPhoneNumber("9991234567"));
    }
}