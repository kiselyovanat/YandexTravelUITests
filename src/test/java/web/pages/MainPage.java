package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.pages.components.CalendarComponent;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
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
    public MainPage openPage(String url) {
        open(url);

        return this;
    }

    @Step("Проверяем пункты меню")
    public MainPage checkMainMenuItems(List<String> menuItems) {
        for (String item : menuItems) {
            menuBar.shouldHave(text(item));
        }

        return this;
    }

    @Step("Открываем категорию")
    public MainPage openCategory(String categoryItem) {
        menuBar.$(byText(categoryItem)).click();

        return this;
    }

    @Step("Проверяем содержимое строки поиска")
    public MainPage checkSearchBarItems(List<String> menuItems) {
        for (String item : menuItems) {
            searchBar.shouldHave(text(item));
        }

        return this;
    }

    @Step("Вводим пункт отправления (Откуда)")
    public MainPage inputDeparture(String departure) {
        if (departureCleanButton.exists()) { //иногда поле заполняется текущей локацией, иногда нет
            departureCleanButton.click();
        }
        departureInput.click();
        departureInput.setValue(departure);
        citySearchResults.$(byText(departure)).click();

        return this;
    }

    @Step("Вводим пункт назначения (Куда)")
    public MainPage inputDestination(String destination) {
        destinationInput.click();
        destinationInput.setValue(destination);
        citySearchResults.$(byText(destination)).click();

        return this;
    }

    @Step("Вводим дату отправления (Туда)")
    public MainPage inputStartDate(String day, String month) {
        startDateInput.click();
        calendarComponent.setDate(day, month);

        return this;
    }

    @Step("Вводим дату возвращения (Оттуда)")
    public MainPage inputEndDate(String day, String month) {
        calendarComponent.setDate(day, month);

        return this;
    }

    @Step("Нажимаем кнопку Найти")
    public MainPage submit() {
        submitButton.click();

        return this;
    }

}
