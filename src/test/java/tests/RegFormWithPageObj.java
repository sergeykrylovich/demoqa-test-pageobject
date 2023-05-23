package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegFormWithPageObj extends TestBase{

    @Test
    void testForm() {

        page.openPage()
                .setFirstName("John")
                .setLastName("Malkovich")
                .setUserEmail("JohnMalkovich@gmail.com")
                .setPhoneNumber("4441122345")
                .setGender("Female")
                .setBirthDate("01", "February", "1994");


        //add data to the 'Subjects' field
        $("#subjectsInput").setValue("Maths").pressEnter().setValue("Physics").pressEnter();
        //select all checkboxes of the 'Hobbies' field
        $("[for='hobbies-checkbox-1']").click(); // Sports
        $("[for='hobbies-checkbox-2']").click(); // Reading
        $("[for='hobbies-checkbox-3']").click(); // Music

        //uploading file for picture
        //File file = new File("src/test/resources/img/img.jpg");
        //$("#uploadPicture").uploadFile(file);
        $("#uploadPicture").uploadFromClasspath("img/img.jpg");

        $("#currentAddress").setValue("17 Dean St, Brooklyn, NY 11201, USA"); // Set Current Address

        //Select City and State fields
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();

//        $("#state").click(); //Select State
//        $("#react-select-3-option-0").click(); // Choose State 'NCR'
//        $("#city").click(); //Select State
//        $("#react-select-4-option-0").click(); // Choose City 'Delhi'
        //$("#submit").click(withTimeout(Duration.ofSeconds(1))); // wait 1 sec and submit
        $("#submit").click(); // submit form

        //Check that the data is saved
        page.verifyModalResults();
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

