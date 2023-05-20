package web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AviaSearchPage {
    private final SelenideElement
            bestPriceOfferAvia = $(byText("лучшая цена"));


    @Step("Проверяем отображение предложения \"Лучшая цена\"")
    public AviaSearchPage checkSearchResultsHasBestPriceOffer() {
        bestPriceOfferAvia.shouldBe(Condition.visible, Duration.ofSeconds(10));


        return this;
    }

}
