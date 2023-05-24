package pages;

import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private static String urlForm = "/automation-practice-form";

    public RegistrationPage openPage() {
        open(urlForm);
        $("div.main-header").shouldHave(text("Practice Form"));
        //Remove footer, so that it does not interfere with pressing submit button
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName (String firstName) {
        $("#firstName").setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName (String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail (String userEmail) {
        $("#userEmail").setValue(userEmail);

        return this;
    }

    public RegistrationPage setPhoneNumber (String userNumber) {
        $("#userNumber").setValue(userNumber);

        return this;
    }

    public RegistrationPage setGender (String userGender) {
        $("#genterWrapper").$(byText(userGender)).click();

        return this;
    }

    public RegistrationPage setBirthDate (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject (String subject) {
        //add data to the 'Subjects' field
        $("#subjectsInput").setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies (String hobbie) {
        //select all checkboxes of the 'Hobbies' field
//        HashMap<String, String> mapOfHobbies = new HashMap();
//        mapOfHobbies.put("Sports", "1");
//        mapOfHobbies.put("Reading", "2");
//        mapOfHobbies.put("Music", "3");

        $("#hobbiesWrapper").$(byText(hobbie)).click(); // Sports
//        $("[for='hobbies-checkbox-2']").click(); // Reading
//        $("[for='hobbies-checkbox-3']").click(); // Music

        return this;
    }

    public RegistrationPage uploadImg (String nameOfImg) {
        //uploading file for picture
        //File file = new File("src/test/resources/img/img.jpg");
        //$("#uploadPicture").uploadFile(file);
        $("#uploadPicture").uploadFromClasspath("img/" + nameOfImg);

        return this;
    }

    public RegistrationPage setAddress (String address) {
        $("#currentAddress").setValue(address); // Set Current Address

        return this;
    }

    public RegistrationPage setCity (String city) {
        $("#city").click();
        $("#city").$(byText(city)).click();
//        $("#city").click(); //Select State
//        $("#react-select-4-option-0").click(); // Choose City 'Delhi'

        return this;
    }

    public RegistrationPage setState (String state) {
        $("#state").click();
        $("#state").$(byText(state)).click();
//        $("#state").click(); //Select State
//        $("#react-select-3-option-0").click(); // Choose State 'NCR'

        return this;
    }

    public RegistrationPage submitForm () {
        $("#submit").click(); // submit form
//        $("#submit").click(withTimeout(Duration.ofSeconds(1)));//  wait 1 sec and submit
        return this;
    }

    public RegistrationPage verifyModalResults () {
        registrationResultModal.verifyModalAppear();

        return this;
    }

    public RegistrationPage verifyResults (String key, String value) {
        registrationResultModal.verifyResultsInModal(key, value);

        return this;
    }

}
