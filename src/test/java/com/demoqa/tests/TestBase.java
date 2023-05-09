package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

   @BeforeAll
    static void BeforeAll () {
       Configuration.baseUrl = "https://demoqa.com";
       Configuration.browserSize = "1920x1080";
       Configuration.browser = "chrome";
       Configuration. pageLoadStrategy="eager";
       Configuration.holdBrowserOpen = true;


   }
}