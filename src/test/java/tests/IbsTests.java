package tests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.SeverityLevel.*;

public class IbsTests extends TestBase {
    final HomePage homePage = new HomePage();
    final SearchPage searchPage = new SearchPage();
    final ContactsPage contactsPage = new ContactsPage();
    final RatingsPage ratingsPage = new RatingsPage();
    final CareerPage careerPage = new CareerPage();

    @DisplayName("Проверка корректной работы поиска в шапке сайта")
    @Tag("Поиск")
    @Severity(NORMAL)
    @Test
    void searchShouldShowCorrectResultsTest() {
        String searchQuery = "Вакансии";

        homePage.openPage()
                .clickOnSearchField()
                .enterSearchQuery(searchQuery);
        searchPage.checkSearchResults(searchQuery);
    }

    @DisplayName("Проверка корректного переключения языка")
    @Tag("Локализация")
    @Severity(CRITICAL)
    @Test
    void clickOnSwitchLanguageTest() {
        String text = "Smart Choices in Evolving Technologies";
        homePage.openPage()
                .clickOnLanguageSwitchButton()
                .checkLanguage(text);
    }

    @DisplayName("Переход на страницу Контакты и проверка адреса")
    @Tag("Контакты")
    @Severity(CRITICAL)
    @Test
    void addressShouldBeCorrectOnContactsPageTest() {
        String address = """
                Россия, 127018, Москва, ул. Складочная, д. 3, стр. 1
                Телефон: +7 (495) 967-80-80
                Факс: +7 (495) 967-80-81
                E-mail: ibs@ibs.ru
                """;

        contactsPage.openPage().checkThatAddressShow(address);
    }

    @MethodSource("menuItemsProvider")
    @ParameterizedTest(name = "Проверка пунктов меню сайта")
    @Tag("Меню")
    @Severity(NORMAL)
    void siteMenuShouldHaveAllItemsTest(List<String> menuItems) {
        homePage.openPage()
                .openSiteMenu();

        for (String item : menuItems) {
            homePage.checkMenuItem(item);
        }
    }

    @Test
    @DisplayName("Проверка работы фильтра на странице рейтинга")
    @Tag("Фильтры")
    @Severity(NORMAL)
    void filterShouldReturnCorrectYear() {
        String year = "2022";

        ratingsPage.openPage()
                .clickOnFilter()
                .chooseYear(year)
                .checkResultYear(year);
    }

    @Test
    @DisplayName("Проверяем поиск по вакансии")
    @Tag("Поиск")
    @Severity(NORMAL)
    void searchJobTest() {
        String jobName = "Тестировщик";

        careerPage.openPage().setValueInSearchField(jobName).checkResult();
    }

    @Test
    @DisplayName("Проверяем фильтр по вакансии")
    @Tag("Фильтр")
    @Severity(NORMAL)
    void filterJobTest() {
        String filterName = "Вакансии без опыта";

        careerPage.openPage().clickOnFilter(filterName).checkFilter(filterName);
    }

    static Stream<Arguments> menuItemsProvider() {
        return Stream.of(
                Arguments.of(List.of(
                        "Услуги",
                        "Решения",
                        "Проекты",
                        "Создано в IBS",
                        "Карьера",
                        "Медиа",
                        "О компании"
                ))
        );
    }
}
