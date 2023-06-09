package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

   @BeforeAll
    static void beforeAll () {
      Configuration.baseUrl = System.getProperty("baseUrl");
      String[] browser = System.getProperty("browser").split(":");
      Configuration.browser = browser[0];
      Configuration.browserVersion = browser[1];
      Configuration.browserSize = System.getProperty("browserSize");
      String selenoidUrl = System.getProperty("selenoidUrl");
      String selenoidLogin = System.getProperty("selenoidLogin");
      String selenoidPassword = System.getProperty("selenoidPassword");
      Configuration.remote = String.format("https://%s:%s@%s", selenoidLogin, selenoidPassword, selenoidUrl);

      //  Configuration.browser = "chrome";
      Configuration.pageLoadStrategy = "eager";

      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("selenoid:options", Map.<String, Object>of(
              "enableVNC", true,
              "enableVideo", true
      ));

      Configuration.browserCapabilities = capabilities;
   }
   @BeforeEach
   void addListener() {
      SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
   }

   @AfterEach
   void addAttachments () {
      Attach.screenshotAs("Last screenshot");
      Attach.pageSource();
      Attach.browserConsoleLogs();
      Attach.addVideo();
   }
}
