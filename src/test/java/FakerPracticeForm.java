import com.codeborne.selenide.conditions.Text;
import com.github.javafaker.Faker;

import org.junit.jupiter.api.Test;

import java.io.File;
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
            dayOfBirth = random.nextInt(27 + 1),
            monthOfBirth = random.nextInt(11),
            yearOfBirth = random.nextInt(120 + 1);

    final String
            demoqa = "https://demoqa.com/automation-practice-form",
            welcometext = "Student Registration Form";
    String
            gender = "Female",
            subject1 = "Eng",
            subject2 = "Co",
            hobby1 = "Sports",
            hobby2 = "Music";

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
        $("#subjectsContainer").click();
        $("#subjectsInput").val(subject1);
        $(".subjects-auto-complete__menu-list").$(byText("English")).click();
        $("#subjectsInput").val(subject2);
        $(".subjects-auto-complete__menu-list").$(byText("Computer Science")).click();
        sleep(1000);
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#currentAddress").val(faker.address().fullAddress());
        sleep(1000);
        //доделать
}

}