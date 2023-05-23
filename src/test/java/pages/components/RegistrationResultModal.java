package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {
    public void verifyModalAppear() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResultsInModal (String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent()
                .shouldHave(text(value));
    }
}
