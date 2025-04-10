package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement searchResult = $(".search-result");

    @Step("Проверяем, что поисковый запрос был найден")
    public SearchPage checkSearchResults(String query) {
        searchResult.shouldHave(text(query));
        return this;
    }
}
