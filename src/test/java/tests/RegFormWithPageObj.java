package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class RegFormWithPageObj extends TestBase{
    //Input data
    String userName = "John"
            , lastName = "Malkovich"
            , userEmail = "JohnMalkovich@gmail.com"
            , phoneNumber = "4441122345"
            , userGender = "Female"
            , dayOfBirth = "01"
            , monthOfBirth = "February"
            , yearOfBirth = "1994"
            , subjectMath = "Math"
            , hobbySport = "Sports"
            , nameOfImg = "img.jpg"
            , address = "17 Dean St, Brooklyn, NY 11201, USA"
            , state = "NCR"
            , city = "Delhi";

    @Test
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
                .setHobbies(hobbySport)
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
                .verifyResults("Hobbies", hobbySport)
                .verifyResults("Picture", nameOfImg)
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city);

    }
}

