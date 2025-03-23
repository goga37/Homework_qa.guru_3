package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {
    private SelenideElement firsNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            state = $("#state"),
            stateSelectInput = $("#react-select-3-input"),
            city = $("#city"),
            citySelectInput = $("#react-select-4-input"),
            submit = $("#submit"),
            modalContent = $(".modal-content"),
            exampleModalTitle = $("#example-modal-sizes-title-lg");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResultComponent tableResultComponent = new TableResultComponent();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeFormPage setFirsName(String value) {
        firsNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setState(String value) {
        state.click();
        stateSelectInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setCity(String value) {
        city.click();
        citySelectInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setSubmit() {
        submit.click();

        return this;
    }

    public PracticeFormPage isResultWindowDisplayed(String value) {
        modalContent.should(appear);
        exampleModalTitle.shouldHave(text(value));

        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        tableResultComponent.checkTableResult(key, value);

        return this;
    }

    public PracticeFormPage shouldNotSeeModal() {
        modalContent.shouldNot(appear);

        return this;
    }
}