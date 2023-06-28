package web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.SearchBarPage;
import web.pages.TrainSearchPage;
import web.testData.SearchData;
import web.testData.SearchDataGenerator;

@Feature("Страница поиска ж/д билетов Яндекс.Путешествия")
public class TrainSearchTests extends TestBase {
    public TrainSearchPage trainSearchPage = new TrainSearchPage();
    public SearchBarPage searchBarPage = new SearchBarPage();

    public String departureCity = "Москва";
    public String destinationCity = "Екатеринбург";

    @Story("Проверяем функцию поиска ж/д билетов")
    @DisplayName("Проверяем наличие результатов поиска ж/д билетов")
    @Test
    void trainSearchResultsExistTest() {
        SearchData trainSearchData = SearchDataGenerator.generateSearchParams(departureCity, destinationCity);
        searchBarPage.openPage()
                .openCategory("Ж/д")
                .inputDeparture(trainSearchData.getDepartureCity())
                .inputDestination(trainSearchData.getDestinationCity())
                .inputStartDate(trainSearchData.getStartDay(), trainSearchData.getStartMonth())
                .inputEndDate(trainSearchData.getEndDay(), trainSearchData.getEndMonth())
                .submit();

        trainSearchPage.checkSearchResultsExist();
    }

    @Story("Проверяем функцию поиска ж/д билетов")
    @DisplayName("Проверяем наличие города-назначения в заголовке результатов поиска ж/д билетов")
    @Test
    void trainSearchHeaderHasDestinationCityTest() {
        SearchData trainSearchData = SearchDataGenerator.generateSearchParams(departureCity, destinationCity);
        searchBarPage.openPage()
                .openCategory("Ж/д")
                .inputDeparture(trainSearchData.getDepartureCity())
                .inputDestination(trainSearchData.getDestinationCity())
                .inputStartDate(trainSearchData.getStartDay(), trainSearchData.getStartMonth())
                .inputEndDate(trainSearchData.getEndDay(), trainSearchData.getEndMonth())
                .submit();

        trainSearchPage.checkSearchResultsHeader(trainSearchData.getDestinationCity());
    }

    @Story("Проверяем отображение фильтра \"Скоростные поезда\"")
    @DisplayName("Проверяем наличие фильтра \"Скоростные поезда\" при поиске ж/д билетов в Санкт-Петербург")
    @Test
    void trainSearchFiltersHasFastTrainFilterTest() {
        SearchData trainSearchData = SearchDataGenerator.generateSearchParams(departureCity, "Санкт-Петербург");
        searchBarPage.openPage()
                .openCategory("Ж/д")
                .inputDeparture(trainSearchData.getDepartureCity())
                .inputDestination(trainSearchData.getDestinationCity())
                .inputStartDate(trainSearchData.getStartDay(), trainSearchData.getStartMonth())
                .inputEndDate(trainSearchData.getEndDay(), trainSearchData.getEndMonth())
                .submit();

        trainSearchPage.checkFastTrainFilterVisible();
    }

    @Story("Проверяем отображение фильтра \"Скоростные поезда\"")
    @DisplayName("Проверяем отсутствие фильтра \"Скоростные поезда\" при поиске ж/д билетов не в Санкт-Петербург")
    @Test
    void trainSearchFiltersDoesNotHaveFastTrainFilterTest() {
        SearchData trainSearchData = SearchDataGenerator.generateSearchParams(departureCity, "Казань");
        searchBarPage.openPage()
                .openCategory("Ж/д")
                .inputDeparture(trainSearchData.getDepartureCity())
                .inputDestination(trainSearchData.getDestinationCity())
                .inputStartDate(trainSearchData.getStartDay(), trainSearchData.getStartMonth())
                .inputEndDate(trainSearchData.getEndDay(), trainSearchData.getEndMonth())
                .submit();

        trainSearchPage.checkFastTrainFilterNotVisible();
    }
}