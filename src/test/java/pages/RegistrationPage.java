package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
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
    private final SelenideElement firstNameSelector = $("#firstName")
            , lastNameSelector = $("#lastName")
            , userEmailSelector = $("#userEmail")
            , phoneNumberSelector = $("#userNumber")
            , genderSelector = $("#genterWrapper")
            , birthDateSelector = $("#dateOfBirthInput")
            , subjectSelector = $("#subjectsInput")
            , hobbiesSelector = $("#hobbiesWrapper")
            , loadImgSelector = $("#uploadPicture")
            , addressSelector = $("#currentAddress")
            , stateSelector = $("#state")
            , citySelector = $("#city")
            , submitSelector = $("#submit");

    @Step("Open demoqa practice form")
    public RegistrationPage openPage() {
        open(urlForm);
        $("div.main-header").shouldHave(text("Practice Form"));
        //Remove footer, so that it does not interfere with pressing submit button
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Set firstname: {firstName} in the form")
    public RegistrationPage setFirstName (String firstName) {
        firstNameSelector.setValue(firstName);

        return this;
    }

    @Step("Set lastname: {lastName} in the form")
    public RegistrationPage setLastName (String lastName) {
        lastNameSelector.setValue(lastName);

        return this;
    }

    @Step("Set  user email: {userEmail} in the form")
    public RegistrationPage setUserEmail (String userEmail) {
        userEmailSelector.setValue(userEmail);

        return this;
    }

    @Step("Set phone number: {userNumber} in the form")
    public RegistrationPage setPhoneNumber (String userNumber) {
        phoneNumberSelector.setValue(userNumber);

        return this;
    }

    @Step("Set gender: {userGender} in the form")
    public RegistrationPage setGender (String userGender) {
        genderSelector.$(byText(userGender)).click();

        return this;
    }

    @Step("Set birthdate: {day}.{month}.{year} in the form")
    public RegistrationPage setBirthDate (String day, String month, String year) {
        birthDateSelector.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Set subject: {subject} in the form")
    public RegistrationPage setSubject (String subject) {
        //add data to the 'Subjects' field
        subjectSelector.setValue(subject).pressEnter();

        return this;
    }

    @Step("Set hobbies: {hobbie} in the form")
    public RegistrationPage setHobbies (String hobbie) {
        hobbiesSelector.$(byText(hobbie)).click(); // chose hobbie

        return this;
    }

    @Step("Upload image in the form")
    public RegistrationPage uploadImg (String nameOfImg) {
        //uploading file for picture
        //File file = new File("src/test/resources/img/img.jpg");
        //$("#uploadPicture").uploadFile(file);
        loadImgSelector.uploadFromClasspath("img/" + nameOfImg);

        return this;
    }

    @Step("Set address: {address} in the form")
    public RegistrationPage setAddress (String address) {
        addressSelector.setValue(address); // Set Current Address

        return this;
    }

    @Step("Set state: {state} in the form")
    public RegistrationPage setState (String state) {
        stateSelector.click();
        stateSelector.$(byText(state)).click();
//        $("#state").click(); //Select State
//        $("#react-select-3-option-0").click(); // Choose State 'NCR'

        return this;
    }

    @Step("Set city: {city} in the form")
    public RegistrationPage setCity (String city) {
        citySelector.click();
        citySelector.$(byText(city)).click();
//        $("#city").click(); //Select State
//        $("#react-select-4-option-0").click(); // Choose City 'Delhi'

        return this;
    }
    @Step("Submit the form")
    public RegistrationPage submitForm () {
        submitSelector.click(); // submit form
//        $("#submit").click(withTimeout(Duration.ofSeconds(1)));//  wait 1 sec and submit
        return this;
    }

    @Step("Verify that modal is appear")
    public RegistrationPage verifyModalResults () {
        registrationResultModal.verifyModalAppear();

        return this;
    }

    @Step("Verify field {key} is equal to {value}")
    public RegistrationPage verifyResults (String key, String value) {
        registrationResultModal.verifyResultsInModal(key, value);

        return this;
    }

}
