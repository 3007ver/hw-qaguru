package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class FormTestsWithDataTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void fillFormTests () {
        step("Open and fill Registration Form", () -> {
                    registrationPage.openPage()
                            .removeHeaderAndFooter()
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setUserEmail(userEmail)
                            .setGender(gender)
                            .setUserNumber(userNumber)
                            .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                            .setSubjects(subjects)
                            .setHobbies(hobby)
                            .uploadPicture(picture)
                            .setAdress(currentAddress)
                            .setState(state)
                            .setCity(city)
                            .clickSubmitButton();
                });

        step("Verify results", () -> {
            registrationPage.verifyModalsAppear()
                    .verifyResults("Student Name", firstName + " " + lastName)
                    .verifyResults("Student Email", userEmail)
                    .verifyResults("Gender", gender)
                    .verifyResults("Mobile", userNumber)
                    .verifyResults("Date of Birth", String.format("%s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth))
                    .verifyResults("Subjects", subjects)
                    .verifyResults("Hobbies", hobby)
                    .verifyResults("Picture", picture)
                    .verifyResults("Address", currentAddress)
                    .verifyResults("State and City", state + " " + city);
        });
    }
}
