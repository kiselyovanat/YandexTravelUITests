package web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.pages.components.CalendarComponent;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement
            departureCleanButton = $(".QDUng"),
            departureInput = $(".Y5YPM").$(".w_eHd"),
            destinationInput = $(".gQElT").$(".w_eHd"),
            citySearchResults = $(".EW8x1"),
            startDateInput = $(".datePickerTrigger_type_startDate"),
            submitButton = $(byText("Найти")),
            bestPriceOfferAvia = $(byText("лучшая цена")),
            searchResultsHeader = $(".JKumV"),
            searchResultsItem = $(".points");

    private CalendarComponent calendarComponent = new CalendarComponent();


    @Step("Вводим пункт отправления (Откуда)")
    public SearchPage inputDeparture(String departure) {
        departureCleanButton.click();
        departureInput.click();
        departureInput.setValue(departure);
        citySearchResults.$(byText(departure)).click();

        return this;
    }

    @Step("Вводим пункт назначения (Куда)")
    public SearchPage inputDestination(String destination) {
        destinationInput.click();
        destinationInput.setValue(destination);
        citySearchResults.$(byText(destination)).click();

        return this;
    }

    @Step("Вводим дату отправления (Туда)")
    public SearchPage inputStartDate(String day, String month) {
        startDateInput.click();
        calendarComponent.setDate(day, month);

        return this;
    }

    @Step("Вводим дату возвращенич (Оттуда)")
    public SearchPage inputEndDate(String day, String month) {
        calendarComponent.setDate(day, month);

        return this;
    }

    @Step("Нажимаем кнопку Найти")
    public SearchPage submit() {
        submitButton.click();

        return this;
    }

    @Step("Проверяем отображение предложения \"Лучшая цена\"")
    public SearchPage checkSearchResultsHasBestPriceOffer() {
        bestPriceOfferAvia.shouldBe(Condition.visible, Duration.ofSeconds(5));


        return this;
    }

    @Step("Проверяем наличие города-назначения в заголовке результатов поиска")
    public SearchPage checkSearchResultsHeader(String destinationCity) {
        searchResultsHeader.shouldBe(visible, Duration.ofSeconds(5));
        searchResultsHeader.shouldHave(text(destinationCity));

        return this;
    }

    @Step("Проверяем наличие результатов поиска")
    public SearchPage checkSearchResultsExist() {
        searchResultsItem.shouldBe(visible, Duration.ofSeconds(5));

        return this;
    }

}
