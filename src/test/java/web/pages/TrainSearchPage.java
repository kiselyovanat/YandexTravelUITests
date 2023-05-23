package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TrainSearchPage {
    private final SelenideElement
            searchResultsHeader = $(".JKumV"),
            searchResultsItem = $(".points"),
            fastTrainFilter = $(".ba14r").$(byText("Скоростные поезда")),
            sortButton = $(".ba14r").$(byText("Сортировка"));

    @Step("Проверяем наличие города-назначения в заголовке результатов поиска")
    public TrainSearchPage checkSearchResultsHeader(String destinationCity) {
        searchResultsHeader.shouldBe(visible, Duration.ofSeconds(10));
        searchResultsHeader.shouldHave(text(destinationCity));

        return this;
    }

    @Step("Проверяем наличие результатов поиска")
    public TrainSearchPage checkSearchResultsExist() {
        searchResultsItem.shouldBe(visible, Duration.ofSeconds(5));

        return this;
    }

    @Step("Проверяем отображение фильтра \"Скоростные поезда\"")
    public TrainSearchPage checkFastTrainFilterVisible() {
        fastTrainFilter.shouldBe(visible, Duration.ofSeconds(15));

        return this;
    }

    @Step("Проверяем, что фильтр \"Скоростные поезда\" не отображается")
    public TrainSearchPage checkFastTrainFilterNotVisible() {
        sortButton.shouldBe(visible, Duration.ofSeconds(15)); //дожидаемся прогрузки блока с фильтрами и сортировкой
        fastTrainFilter.shouldNotBe(visible); // проверяем

        return this;
    }
}
