package com.demoqa.tests;

import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationPage;

public class FormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillFormTests () {
        registrationPage.openPage()
                        .removeHeaderAndFooter()
                        .setFirstName("John")
                        .setLastName("James")
                        .setUserEmail("test@gmail.com")
                        .setGender("Male")
                        .setUserNumber("8905675432")
                        .setBirthDate("14","November","1985")
                        .setSubjects("Chemistry")
                        .setHobbies("Reading")
                        .uploadPicture()
                        .setAdress("Main Str.87")
                        .setState("Uttar Pradesh")
                        .setCity("Lucknow")
                        .clickButton();

        registrationPage.verifyModalsAppear()
                        .verifyResults("Student Name","John James")
                        .verifyResults("Student Email","test@gmail.com")
                        .verifyResults("Gender", "Male")
                        .verifyResults("Mobile", "8905675432")
                        .verifyResults("Date of Birth", "14 November,1985")
                        .verifyResults("Subjects", "Chemistry")
                        .verifyResults("Hobbies", "Reading")
                        .verifyResults("Picture", "image.jpg")
                        .verifyResults("Address", "Main Str.87")
                        .verifyResults("State and City", "Uttar Pradesh Lucknow");

    }
}
