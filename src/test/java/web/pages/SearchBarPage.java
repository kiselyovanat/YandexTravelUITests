package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.pages.components.CalendarComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchBarPage {
    private final SelenideElement
            menuBar = $(".GGc2p"),
            searchBar = $(".RhypN"),
            departureCleanButton = $(".QDUng"),
            departureInput = $(".Y5YPM").$(".w_eHd"),
            destinationInput = $(".gQElT").$(".w_eHd"),
            citySearchResults = $(".EW8x1"),
            startDateInput = $(".datePickerTrigger_type_startDate"),
            submitButton = $(byText("Найти"));
    private CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открываем главную страницу")
    public SearchBarPage openPage() {
        open("/");

        return this;
    }

    @Step("Проверяем пункты меню")
    public SearchBarPage checkMainMenuItems(List<String> menuItems) {
        for (String item : menuItems) {
            menuBar.shouldHave(text(item));
        }

        return this;
    }

    @Step("Открываем категорию")
    public SearchBarPage openCategory(String categoryItem) {
        menuBar.$(byText(categoryItem)).click();

        return this;
    }

    @Step("Проверяем содержимое строки поиска")
    public SearchBarPage checkSearchBarItems(List<String> menuItems) {
        for (String item : menuItems) {
            searchBar.shouldHave(text(item));
        }

        return this;
    }

    @Step("Вводим пункт отправления (Откуда)")
    public SearchBarPage inputDeparture(String departure) {
        this.clearAutocompleteValueIfPresent(3);
        departureInput.click();
        departureInput.setValue(departure);
        citySearchResults.$(byText(departure)).click();

        return this;
    }

    @Step("Вводим пункт назначения (Куда)")
    public SearchBarPage inputDestination(String destination) {
        destinationInput.click();
        destinationInput.setValue(destination);
        citySearchResults.$(byText(destination)).click();

        return this;
    }

    @Step("Вводим дату отправления (Туда)")
    public SearchBarPage inputStartDate(String day, String month) {
        startDateInput.click();
        calendarComponent.setDate(day, month);

        return this;
    }

    @Step("Вводим дату возвращения (Оттуда)")
    public SearchBarPage inputEndDate(String day, String month) {
        calendarComponent.setDate(day, month);

        return this;
    }

    @Step("Нажимаем кнопку Найти")
    public SearchBarPage submit() {
        submitButton.click();

        return this;
    }

    private SearchBarPage clearAutocompleteValueIfPresent(int maxWaitTimeInSeconds) {
        long start = System.currentTimeMillis();
        long end = start + maxWaitTimeInSeconds * 1000;
        while (System.currentTimeMillis() < end) {
            if (departureCleanButton.is(visible)) {
                departureCleanButton.click();
                break;
            }
        }
        return this;
    }
}
