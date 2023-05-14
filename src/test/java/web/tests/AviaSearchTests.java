package web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import web.pages.MainPage;
import web.pages.SearchPage;
import web.testData.AviaSearchData;
import web.testData.AviaSearchDataGenerator;


public class AviaSearchTests extends TestBase {

    public SearchPage searchPage = new SearchPage();
    public MainPage mainPage = new MainPage();

    @Feature("Страница поиска авиабилетов Яндекс.Путешествия")
    @Story("Проверяем функцию поиска авиабилетов")
    @DisplayName("Проверяем наличие результатов поиска авиабилетов в Белград")
    @Test
    void aviaSearchTest() {
        AviaSearchData aviaSearchData = AviaSearchDataGenerator.generateSearchParams();
        mainPage.openPage("/")
                .openCategory("Авиа");

        searchPage.inputDestination(aviaSearchData.getCity())
                .inputStartDate(aviaSearchData.getStartDay(), aviaSearchData.getStartMonth())
                .inputEndDate(aviaSearchData.getEndDay(), aviaSearchData.getEndMonth())
                .submit()
                .checkSearchResultsHasBestPriceOffer();

    }
}
