import com.codeborne.selenide.conditions.Text;
import com.github.javafaker.Faker;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class FakerPracticeForm {
    Faker faker = new Faker();
    Random random = new Random();
    int
            dayOfBirth = random.nextInt(30 + 1),
            monthOfBirth = random.nextInt(11),
            yearOfBirth = random.nextInt(120 + 1);

    final String
            demoqa = "https://demoqa.com/automation-practice-form",
            welcometext = "Student Registration Form";
    String
            gender = "Female",
            subject1 = "En",
            subject2 = "Co";

    @Test
    void SelenideFaker() {
        open(demoqa);
        $(".practice-form-wrapper").shouldHave(text(welcometext));
        $("#firstName").setValue(faker.name().firstName());
        $("#lastName").setValue(faker.name().lastName());
        $("#userEmail").setValue(faker.internet().emailAddress());
        $(byText(gender)).click();
        $("#userNumber").setValue(faker.phoneNumber().phoneNumber());
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
        sleep(3000);
        $("#subjectInput").val(subject1);
        $(".subjects-auto-complete__menu-list").$(byText(subject1)).click();

}

}