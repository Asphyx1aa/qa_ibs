package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RatingsPage {
    private final SelenideElement filter = $(".selection"),
            resultYear = $(".approve-group__year"),
            newsResultYear = $(".approve-item__source");

    @Step("Открываем страницу рейтингов")
    public RatingsPage openPage() {
        open("/about/ratings/");
        return this;
    }

    @Step("Кликаем по фильтру")
    public RatingsPage clickOnFilter() {
        filter.shouldBe(visible);
        filter.click();
        return this;
    }

    @Step("Выбираем год {year}")
    public RatingsPage chooseYear(String year) {
        $(byText(year)).click();
        return this;
    }

    @Step("Проверяем выбранный год")
    public RatingsPage checkResultYear(String year) {
        resultYear.shouldHave(text(year));
        newsResultYear.shouldBe(visible).shouldHave(text(year));
        return this;
    }


}
