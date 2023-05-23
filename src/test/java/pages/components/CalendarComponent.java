package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month,String year) {
        //Set value of date birth with keyboard
        //Select all data in 'Date of Birth' field
        //$("#dateOfBirthInput").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        //append a birth date to the 'Date of Birth' field and press enter
        //$("#dateOfBirthInput").append("02 FEB 1990").pressEnter();
        //Set value of date birth with click

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
