package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

    public class TextBoxTests extends TestBase {
        TextBoxPage textBoxPage = new TextBoxPage();
        @Test
        void successfulFillFormTest() {
            textBoxPage.openPage()
                        .removeHeaderAndFooter()
                        .setUserName("John James")
                        .setUserEmail("test@gmail.com")
                        .setCurrentAddress("First Address")
                        .setPermanentAddress("Second Address")
                        .clickButton();

            textBoxPage.verifyResults("John James")
                        .verifyResults("test@gmail.com")
                        .verifyResults("First Address")
                        .verifyResults("Second Address");
        }
}
