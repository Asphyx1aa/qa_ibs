package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContactsPage {
    private final SelenideElement addressBlock = $("p[itemprop='address']");

    @Step("Открываем страницу Контакты")
    public ContactsPage openPage() {
        open("/contacts");
        return this;
    }

    @Step("Проверяем, что отображается адрес на странице")
    public ContactsPage checkThatAddressShow(String address) {
        addressBlock.shouldBe(visible);
        addressBlock.scrollTo().shouldHave(text(address));
        return this;
    }
}
