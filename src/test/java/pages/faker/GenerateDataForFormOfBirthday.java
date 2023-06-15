package pages.faker;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class GenerateDataForFormOfBirthday {
    Faker faker = new Faker();
    public String setDateOfBirth(String[] listDate, String choice) {
        if (choice.equalsIgnoreCase("day")) {
            return listDate[0];
        } else if (choice.equalsIgnoreCase("month")) {
            return listDate[1];
        } else {
            return listDate[2]; //return year
        }
    }

    public String[] generateDateOfBirth (int minAge, int maxAge) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy", Locale.ENGLISH);
        String[] listDate = sdf.format(faker.date().birthday(minAge, maxAge)).split("/");
        return listDate;
    }

}
