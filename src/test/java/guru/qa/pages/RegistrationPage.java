package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            resultsTable = $(".table"),
            currentAddressInput = $("#currentAddress"),
            genderSelect = $(byText("Female")),
            subjectInput = $("#subjectsInput"),
            subjectClicker = $("#react-select-2-option-2"),
            hobbiesSelect = $(byText("Reading")),
            pictureUploader = $("#uploadPicture");

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text("Student Registration Form"));

        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage selectGender() {
        genderSelect.click();

        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue(value);

        return this;
    }

    public RegistrationPage selectSubject() {
        subjectClicker.click();

        return this;
    }

    public RegistrationPage selectHobbies() {
        hobbiesSelect.click();

        return this;
    }

    public RegistrationPage choosePicture(String value) {
        pictureUploader.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage checkResultsValue(String  key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
