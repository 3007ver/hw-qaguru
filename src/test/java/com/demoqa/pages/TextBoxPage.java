package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    SelenideElement userName = $("#userName"),
                    userEmail = $("#userEmail"),
                    currentAddress = $("#currentAddress"),
                    permanentAddress =  $("#permanentAddress"),
                    button =  $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }
    public TextBoxPage removeHeaderAndFooter () {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public TextBoxPage setUserName (String value) {
        userName.setValue(value);

        return this;
    }
    public TextBoxPage setUserEmail (String value) {
        userEmail.setValue(value);

        return this;
    }
    public TextBoxPage setCurrentAddress (String value) {
        currentAddress.setValue(value);

        return this;
    }
    public TextBoxPage setPermanentAddress (String value) {
        permanentAddress.setValue(value);

        return this;
    }
    public TextBoxPage clickButton() {
        button.click();

        return this;
    }
    public TextBoxPage verifyResults (String value) {
        $("#output").shouldHave(text(value));

        return this;
    }
}
