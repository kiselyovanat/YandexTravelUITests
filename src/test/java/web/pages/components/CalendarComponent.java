package web.pages.components;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month){
        $(".monthsList").$(byText(month)).click();
        $(".aCtN8").$(byText(month)).parent().parent().$(byText(day)).click();
    }
}
