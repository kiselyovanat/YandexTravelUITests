package web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.AviaSearchPage;
import web.pages.SearchBarPage;
import web.testData.SearchData;
import web.testData.SearchDataGenerator;

@Feature("Страница поиска авиабилетов Яндекс.Путешествия")
public class AviaSearchTests extends TestBase {

    public AviaSearchPage aviaSearchPage = new AviaSearchPage();
    public SearchBarPage searchBarPage = new SearchBarPage();

    @Story("Проверяем функцию поиска авиабилетов")
    @DisplayName("Проверяем наличие лучшего предложения среди результатов поиска авиабилетов из Москвы в Белград")
    @Test
    void aviaBestPriceOfferSearchTest() {
        SearchData aviaSearchData = SearchDataGenerator.generateSearchParams("Москва", "Белград");
        searchBarPage.openPage()
                .openCategory("Авиа")
                .inputDeparture(aviaSearchData.getDepartureCity())
                .inputDestination(aviaSearchData.getDestinationCity())
                .inputStartDate(aviaSearchData.getStartDay(), aviaSearchData.getStartMonth())
                .inputEndDate(aviaSearchData.getEndDay(), aviaSearchData.getEndMonth())
                .submit();

        aviaSearchPage.checkSearchResultsHasBestPriceOffer();
    }
}
