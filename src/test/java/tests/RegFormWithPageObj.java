package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegFormWithPageObj extends TestBase{
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
            , pathOfImg = "img/img.jpg"
            , address = "17 Dean St, Brooklyn, NY 11201, USA"
            , city = "NCR"
            , state = "Delhi";

    @Test
    void testForm() {

        page.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setPhoneNumber(phoneNumber)
                .setGender(userGender)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjectMath)
                .setHobbies(hobbySport)
                .uploadImg(pathOfImg)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();


        //Check that the data is saved
        page.verifyModalResults()
                .verifyResults("Student name", "");
        $(".table-responsive").shouldHave(text("John"))
                .shouldHave(text("Malkovich"))
                .shouldHave(text("JohnMalkovich@gmail.com"))
                .shouldHave(text("4441122345"))
                .shouldHave(text("1990"))
                .shouldHave(text("Maths"))
                .shouldHave(text("NCR "))
                .shouldHave(text("Delhi"))
                .shouldHave(text("Sports"))
                .shouldHave(text("Male"));
    }
}

