package com.demoqa.tests;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker ();

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1986,2004)),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1,28)),
            monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            subjects = faker.options().option("Maths", "Accounting", "Arts", "Social Studies", "Hindi", "English", "Chemistry", "Computer Science", "Commerce","Physics","Biology", "Civics", "History"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            picture = "image.jpg",
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = randomCity();

    public static String randomCity() {
        String city;
        switch (state) {
            case "NCR": {
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                return city;
            }
            case "Uttar Pradesh": {
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                return city;
            }
            case "Haryana": {
                city = faker.options().option("Karnal", "Panipat");
                return city;
            }
            case "Rajasthan": {
                city = faker.options().option("Jaipur", "Jaiselmer");
                return city;

            }
        }
        return null;
    }
}
