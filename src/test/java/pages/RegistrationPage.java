package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private static String urnForm = "/automation-practice-form";

    public RegistrationPage openPage() {
        open(urnForm);
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
        $("#genterWrapper").$(byText("userGender")).click();

        return this;
    }

}
