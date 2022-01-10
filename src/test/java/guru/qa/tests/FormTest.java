package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;
import static guru.qa.tests.TestData.*;

import com.github.javafaker.Faker;

import java.util.Calendar;

public class FormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserEmail(testData.userEmail)
                .selectGender()
                .typeUserNumber(testData.userNumber)
                .selectDate("18", "April", "1990")
                .typeSubject(testData.subject)
                .selectSubject()
                .selectHobbies()
                .choosePicture(testData.pictureName)
                .typeCurrentAddress(testData.currentAddress)
                .selectState()
                .chooseCity(testData.firstCity)
                .selectCity()
                .chooseCity(testData.secondCity)
                .clickSubmitButton()
                .checkResultsValue("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultsValue("Student Email", testData.userEmail)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", testData.userNumber)
                .checkResultsValue("Date of Birth", "18 April,1990")
                .checkResultsValue("Subjects", "Arts")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", testData.pictureName)
                .checkResultsValue("Address", testData.currentAddress)
                .checkResultsValue("State and City", testData.firstCity + " " + testData.secondCity)
                .clickCloseButton();
    }
}
