package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class RegFormWithPageObj extends TestBase{
    //Input data
    Faker faker = new Faker();
    private final String userName = faker.name().firstName();
    private final String lastName = faker.name().lastName();
    private final String userEmail = faker.internet().emailAddress();
    private String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    private final String userGender = "Female";
    private final String[] dateList = generateDataForFormOfBirthday.generateDateOfBirth(18, 90); // generate date to array
    private final String dayOfBirth = generateDataForFormOfBirthday.setDateOfBirth(dateList, "day");
    private final String monthOfBirth = generateDataForFormOfBirthday.setDateOfBirth(dateList, "month");
    private final String yearOfBirth = generateDataForFormOfBirthday.setDateOfBirth(dateList, "year");
    private final String subjectMath = "Math";
    private final String hobbie = "Sports";
    private final String nameOfImg = "img.jpg";
    private final String address = faker.address().fullAddress();
    private final String state = "NCR";
    private final String city = "Delhi";

    @Test
    @Tag("remote_test")
    @Owner(value = "Sergei Krylovich")
    @Severity(SeverityLevel.NORMAL)
    @Story("Fill demoqa form with data")
    @Description("Test demoqa form with positive data")
    void testForm() {
        //Form filling
        page.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setPhoneNumber(phoneNumber)
                .setGender(userGender)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjectMath)
                .setHobbies(hobbie)
                .uploadImg(nameOfImg)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();


        //Check that the data is saved
        page.verifyModalResults()
                .verifyResults("Student Name", userName + " " + lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", userGender)
                .verifyResults("Mobile", phoneNumber)
                .verifyResults("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResults("Subjects", subjectMath)
                .verifyResults("Hobbies", hobbie)
                .verifyResults("Picture", nameOfImg)
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city);

    }
}

