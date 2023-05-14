package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement
            menuBar = $(".GGc2p"),
            searchBar = $(".RhypN");

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

}
