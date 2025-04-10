package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class HomePage {
    private final SelenideElement headerSearch = $(".js-header-search"),
            searchInput = $(".js-search-input"),
            languageSwitcher = $(byText("Eng")),
            homePageTitle = $(".top-slide__title"),
            contactsLink = $("a[href='/contacts/']"),
            headerBurger = $(".header-burger"),
            navSections = $(".navigation-sections");

    @Step("Открываем главную страницу")
    public HomePage openPage() {
        open("");
        return this;
    }

    @Step("Кликаем по поиску в шапке")
    public HomePage clickOnSearchField() {
        headerSearch.click();
        return this;
    }

    @Step("Открываем боковое меню сайта")
    public HomePage openSiteMenu() {
        headerBurger.click();
        return this;
    }

    @Step("Вводим поисковый запрос {query} и подтверждаем ввод")
    public HomePage enterSearchQuery(String query) {
        searchInput.setValue(query).pressEnter();
        return this;
    }

    @Step("Кликаем по кнопке смены языка")
    public HomePage clickOnLanguageSwitchButton() {
        languageSwitcher.click();
        return this;
    }

    @Step("Открываем страницу Контакты")
    public HomePage openContactsPage() {
        contactsLink.click();
        return this;
    }

    @Step("Убеждаемся, что язык переключился на английский")
    public HomePage checkLanguageSwitched(String value) {
        homePageTitle.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем разделы в меню сайта")
    public HomePage checkMenuItems(String item) {
        navSections.shouldHave(text(item));
        return this;
    }
}
