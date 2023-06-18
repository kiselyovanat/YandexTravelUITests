package web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.AviaSearchPage;
import web.pages.MainPage;
import web.testData.SearchData;
import web.testData.SearchDataGenerator;

public class AviaSearchTests extends TestBase {

    public AviaSearchPage aviaSearchPage = new AviaSearchPage();
    public MainPage mainPage = new MainPage();

    @Feature("Страница поиска авиабилетов Яндекс.Путешествия")
    @Story("Проверяем функцию поиска авиабилетов")
    @DisplayName("Проверяем наличие лучшего предложения среди результатов поиска авиабилетов из Москвы в Белград")
    @Test
    @Tag("UITest")
    void aviaBestPriceOfferSearchTest() throws InterruptedException {
        SearchData aviaSearchData = SearchDataGenerator.generateSearchParams("Москва", "Белград");
        mainPage.openPage("/")
                .openCategory("Авиа")
                .inputDeparture(aviaSearchData.getDepartureCity())
                .inputDestination(aviaSearchData.getDestinationCity())
                .inputStartDate(aviaSearchData.getStartDay(), aviaSearchData.getStartMonth())
                .inputEndDate(aviaSearchData.getEndDay(), aviaSearchData.getEndMonth())
                .submit();

        aviaSearchPage.checkSearchResultsHasBestPriceOffer();
    }
}
