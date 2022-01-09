package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.tests.TestData.*;

import com.github.javafaker.Faker;

public class FormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail);
        $(byText("Female")).click();
        registrationPage.typeUserNumber(userNumber)
                .calendarComponent.setDate("18", "April", "1990");
        $("#subjectsInput").setValue("a");
        $("#react-select-2-option-2").click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("file.txt");
        registrationPage.typeCurrentAddress(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", userNumber)
                .checkResultsValue("Date of Birth", "18 April,1990")
                .checkResultsValue("Subjects", "Arts")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "file.txt")
                .checkResultsValue("Address", currentAddress)
                .checkResultsValue("State and City", "NCR Delhi");
        $("#closeLargeModal").click();
    }
}