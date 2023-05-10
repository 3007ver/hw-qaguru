package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModalComponent;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModalComponent resultsModal = new ResultsModalComponent();
    SelenideElement firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                    gender = $("#genterWrapper"),
                    userNumber = $("#userNumber"),
                    dateOfBirthInput = $("#dateOfBirthInput"),
                    subjectsInput = $("#subjectsInput"),
                    hobbies = $("#hobbiesWrapper"),
                    uploadPicture = $("#uploadPicture"),
                    currentAdressInput = $("#currentAddress"),
                    state = $("#state"),
                    city = $("#city"),
                    submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeHeaderAndFooter () {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender (String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber (String value) {
      userNumber.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDate (String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubjects (String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbies (String value) {
        hobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture (String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAdress (String value) {
        currentAdressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState (String value) {
        state.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity (String value) {
        city.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmitButton () {
        submitButton.click();

        return this;
    }
    public RegistrationPage verifyModalsAppear () {
        resultsModal.verifyModalAppears();

        return this;
    }
    public RegistrationPage verifyResults (String key, String value) {
        resultsModal.verifyResult(key, value);

        return this;
    }

}
