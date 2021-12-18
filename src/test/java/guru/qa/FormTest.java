package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $("#userNumber").setValue("89091055555");
        $("#dateOfBirthInput").setValue("18 Apr 1990");
        executeJavaScript("$('.datepicker').hide();");
        $("#subjectsInput").setValue("a");
        $("#react-select-2-option-3").click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("file.txt");
        $("#currentAddress").setValue("Test st., 6");
        $("#submit").click();
        }
}
