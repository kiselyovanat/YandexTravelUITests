package web.tests;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "112.0");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://travel.yandex.ru");
        Configuration.pageLoadStrategy = "eager";
        //Configuration.remote = "https://user1:1234@"+ System.getProperty("selenoidUrl", "selenoid.autotests.cloud/wd/hub");
        //onfiguration.holdBrowserOpen = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
