package web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import web.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement
            destinationInput = $(".gQElT").$(".w_eHd"),
            destinationSearchResults = $(".EW8x1"),
            startDateInput = $(".datePickerTrigger_type_startDate"),
            submitButton = $(byText("Найти")),
            bestPriceOffer = $(byText("лучшая цена"));
    private CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Вводим пункт назначения (Куда)")
    public SearchPage inputDestination(String destination) {
        destinationInput.click();
        destinationInput.setValue(destination);
        destinationSearchResults.$(byText(destination)).click();

        return this;
    }

    @Step("Вводим дату перетелета (Туда)")
    public SearchPage inputStartDate(String day, String month) {
        startDateInput.click();
        calendarComponent.setDate(day, month);

        return this;
    }

    @Step("Вводим дату перетелета (Оттуда)")
    public SearchPage inputEndDate(String day, String month) {
        calendarComponent.setDate(day, month);

        return this;
    }

    @Step("Нажимаем кнопку Найти")
    public SearchPage submit() {
        submitButton.click();

        return this;
    }

    public SearchPage checkSearchResultsHasBestPriceOffer() {
        bestPriceOffer.shouldBe(Condition.visible);
        Assertions.assertTrue(bestPriceOffer.exists());

        return this;
    }


}
