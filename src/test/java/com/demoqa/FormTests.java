package com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTests extends TestBase {
    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("#firstName").setValue("John");
        $("#lastName").setValue("James");
        $("#userEmail").setValue("test@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89056754321");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__month").$(byText("14")).click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/image.jpg"));
        $("#currentAddress").setValue("Main Str.87");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(
                text("John James"),
                text("test@gmail.com"),
                text("Male"),
                text("8905675432"),
                text("14 November,1985"),
                text("Chemistry"),
                text("Reading"),
                text("image.jpg"),
                text("Main Str.87"),
                text("Uttar Pradesh Lucknow")

        );

    }
}
