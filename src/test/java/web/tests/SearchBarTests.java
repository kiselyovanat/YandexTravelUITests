package web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import web.pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

public class SearchBarTests extends TestBase {
    public MainPage mainPage = new MainPage();

    static Stream<Arguments> mainMenuContentTest() {
        return Stream.of(
                Arguments.of(List.of("Отели", "Авиа", "Ж/д", "Автобусы", "Туры"))
        );
    }

    static Stream<Arguments> searchBarContentTest() {
        return Stream.of(
                Arguments.of("Отели", List.of("Куда вы хотите поехать?", "Заезд", "Выезд", "2 взрослых", "Найти")),
                Arguments.of("Авиа", List.of("Откуда", "Куда", "Туда", "Обратно", "1 пассажир", "Найти")),
                Arguments.of("Ж/д", List.of("Откуда", "Куда", "Туда", "Обратно", "Найти")),
                Arguments.of("Автобусы", List.of("Откуда", "Куда", "Когда", "Найти")),
                Arguments.of("Туры", List.of("Откуда", "Куда", "Когда", "7 ночей", "2 взрослых", "Найти"))
        );
    }

    @Feature("Главная страница сайта Яндекс.Путешествия")
    @Story("Проверяем содержимое главной страницы")
    @DisplayName("Проверяем пункты меню: ")
    @ParameterizedTest(name = "пункты меню содержат {0}")
    @MethodSource
    void mainMenuContentTest(List<String> menuItems) {
        mainPage.openPage("/")
                .checkMainMenuItems(menuItems);
    }

    @Feature("Главная страница сайта Яндекс.Путешествия")
    @Story("Проверяем содержимое главной страницы")
    @DisplayName("Проверяем пункты строк поиска во всех категориях: ")
    @ParameterizedTest(name = "cтрока поиска на странице {0} содержит пункты {1}")
    @MethodSource
    void searchBarContentTest(String category, List<String> searchBarItems) {
        mainPage.openPage("/")
                .openCategory(category)
                .checkSearchBarItems(searchBarItems);
    }

}
