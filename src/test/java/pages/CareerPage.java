package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.impl.Html.text;

public class CareerPage {

    final SelenideElement searchJobInput = $(".job__search_input"),
            filterTag = $(".filter__tag_title");
    ElementsCollection jobResult = $$(".job_group__items");

    public CareerPage openPage() {
        open("/career/jobs");
        return this;
    }

    public CareerPage setValueInSearchField(String value) {
        searchJobInput.setValue(value).pressEnter();
        return this;
    }

    public CareerPage checkResult() {
        jobResult.shouldBe(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public CareerPage clickOnFilter(String text) {
        $$(".checkbox").findBy(text(text)).click();
        return this;
    }

    public CareerPage checkFilter(String text) {
        filterTag.shouldBe(visible).shouldHave(text(text));
        return this;
    }

}
