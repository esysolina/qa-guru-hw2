package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {
        @BeforeAll
        static void beforeAll() {
        Configuration.startMaximized = true;
        }

        @Test
        void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Super");
        $("#lastName").setValue("Student");
        $("#userEmail").setValue("test@test.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("8909105555");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--018:not(.react-datepicker__day--outside-month").click();

        $("#subjectsInput").setValue("a");
        $("#react-select-2-option-2").click();

        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("file.txt");
        $("#currentAddress").setValue("Test st., 6");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $x("//tr[1]/td[2]").shouldHave(text("Super Student"));
        $x("//tr[2]/td[2]").shouldHave(text("test@test.ru"));
        $x("//tr[3]/td[2]").shouldHave(text("Female"));
        $x("//tr[4]/td[2]").shouldHave(text("8909105555"));
        $x("//tr[5]/td[2]").shouldHave(text("18 April,1990"));
        $x("//tr[6]/td[2]").shouldHave(text("Arts"));
        $x("//tr[7]/td[2]").shouldHave(text("Reading"));
        $x("//tr[8]/td[2]").shouldHave(text("file.txt"));
        $x("//tr[9]/td[2]").shouldHave(text("Test st., 6"));
        $x("//tr[10]/td[2]").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
        }
}
