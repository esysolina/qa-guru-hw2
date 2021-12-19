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

                $(".table").shouldHave(text("Super Student"),text("test@test.ru"),text("Female"),text("8909105555"),
                        text("18 April,1990"),text("Arts"),text("Reading"),text("file.txt"),text("Test st., 6"),text("NCR Delhi"));
                $("#closeLargeModal").click();
        }
}
