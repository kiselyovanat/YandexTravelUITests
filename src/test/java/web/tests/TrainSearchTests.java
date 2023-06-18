package web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.MainPage;
import web.pages.TrainSearchPage;
import web.testData.SearchData;
import web.testData.SearchDataGenerator;

public class TrainSearchTests extends TestBase {
    public TrainSearchPage trainSearchPage = new TrainSearchPage();
    public MainPage mainPage = new MainPage();

    public String departureCity = "Москва";
    public String destinationCity = "Екатеринбург";

    @Feature("Страница поиска ж/д билетов Яндекс.Путешествия")
    @Story("Проверяем функцию поиска ж/д билетов")
    @DisplayName("Проверяем наличие результатов поиска ж/д билетов")
    @Test
    @Tag("UITest")
    void trainSearchResultsExistTest() throws InterruptedException {
        SearchData trainSearchData = SearchDataGenerator.generateSearchParams(departureCity, destinationCity);
        mainPage.openPage("/")
                .openCategory("Ж/д")
                .inputDeparture(trainSearchData.getDepartureCity())
                .inputDestination(trainSearchData.getDestinationCity())
                .inputStartDate(trainSearchData.getStartDay(), trainSearchData.getStartMonth())
                .inputEndDate(trainSearchData.getEndDay(), trainSearchData.getEndMonth())
                .submit();

        trainSearchPage.checkSearchResultsExist();
    }

    @Feature("Страница поиска ж/д билетов Яндекс.Путешествия")
    @Story("Проверяем функцию поиска ж/д билетов")
    @DisplayName("Проверяем наличие города-назначения в заголовке результатов поиска ж/д билетов")
    @Test
    @Tag("UITest")
    void trainSearchHeaderHasDestinationCityTest() throws InterruptedException {
        SearchData trainSearchData = SearchDataGenerator.generateSearchParams(departureCity, destinationCity);
        mainPage.openPage("/")
                .openCategory("Ж/д")
                .inputDeparture(trainSearchData.getDepartureCity())
                .inputDestination(trainSearchData.getDestinationCity())
                .inputStartDate(trainSearchData.getStartDay(), trainSearchData.getStartMonth())
                .inputEndDate(trainSearchData.getEndDay(), trainSearchData.getEndMonth())
                .submit();

        trainSearchPage.checkSearchResultsHeader(trainSearchData.getDestinationCity());
    }

    @Feature("Страница поиска ж/д билетов Яндекс.Путешествия")
    @Story("Проверяем отображение фильтра \"Скоростные поезда\"")
    @DisplayName("Проверяем наличие фильтра \"Скоростные поезда\" при поиске ж/д билетов в Санкт-Петербург")
    @Test
    @Tag("UITest")
    void trainSearchFiltersHasFastTrainFilterTest() throws InterruptedException {
        SearchData trainSearchData = SearchDataGenerator.generateSearchParams(departureCity, "Санкт-Петербург");
        mainPage.openPage("/")
                .openCategory("Ж/д")
                .inputDeparture(trainSearchData.getDepartureCity())
                .inputDestination(trainSearchData.getDestinationCity())
                .inputStartDate(trainSearchData.getStartDay(), trainSearchData.getStartMonth())
                .inputEndDate(trainSearchData.getEndDay(), trainSearchData.getEndMonth())
                .submit();

        trainSearchPage.checkFastTrainFilterVisible();
    }

    @Feature("Страница поиска ж/д билетов Яндекс.Путешествия")
    @Story("Проверяем отображение фильтра \"Скоростные поезда\"")
    @DisplayName("Проверяем отсутствие фильтра \"Скоростные поезда\" при поиске ж/д билетов не в Санкт-Петербург")
    @Test
    @Tag("UITest")
    void trainSearchFiltersDoesNotHaveFastTrainFilterTest() throws InterruptedException {
        SearchData trainSearchData = SearchDataGenerator.generateSearchParams(departureCity, "Казань");
        mainPage.openPage("/")
                .openCategory("Ж/д")
                .inputDeparture(trainSearchData.getDepartureCity())
                .inputDestination(trainSearchData.getDestinationCity())
                .inputStartDate(trainSearchData.getStartDay(), trainSearchData.getStartMonth())
                .inputEndDate(trainSearchData.getEndDay(), trainSearchData.getEndMonth())
                .submit();

        trainSearchPage.checkFastTrainFilterNotVisible();
    }
}