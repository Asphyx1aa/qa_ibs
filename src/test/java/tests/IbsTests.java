package tests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.ContactsPage;
import pages.HomePage;
import pages.RatingsPage;
import pages.SearchPage;

import static io.qameta.allure.SeverityLevel.*;

public class IbsTests extends TestBase {
    final HomePage homePage = new HomePage();
    final SearchPage searchPage = new SearchPage();
    final ContactsPage contactsPage = new ContactsPage();
    final RatingsPage ratingsPage = new RatingsPage();

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
                .checkLanguageSwitched(text);
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

        homePage.openPage().openContactsPage();
        contactsPage.checkThatAddressShow(address);
    }

    @CsvFileSource(resources = "/menuItems.csv")
    @ParameterizedTest(name = "Проверка пунктов меню сайта")
    @Tag("Меню")
    @Severity(NORMAL)
    void siteMenuShouldHaveAllItemsTest(String services, String solutions, String projects, String createdInIbs, String career, String media,
                                        String aboutCompany) {
        homePage.openPage()
                .openSiteMenu()
                .checkMenuItems(services)
                .checkMenuItems(solutions)
                .checkMenuItems(projects)
                .checkMenuItems(createdInIbs)
                .checkMenuItems(career)
                .checkMenuItems(media)
                .checkMenuItems(aboutCompany);
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
}
