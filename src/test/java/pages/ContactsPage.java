package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ContactsPage {
    private final SelenideElement addressBlock = $("p[itemprop='address']");

    @Step("Проверяем, что отображается адрес на странице")
    public ContactsPage checkThatAddressShow(String address) {
        addressBlock.shouldHave(text(address));
        return this;
    }
}
