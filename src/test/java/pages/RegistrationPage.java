package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private final SelenideElement
            lastNameInput = $("#lastName"),
            firstNameInput = $("#firstName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            closeCookie = $(".fc-button.fc-cta-consent.fc-primary-button"),
            dateOfBirthInput = $("#dateOfBirthInput");


    public RegistrationPage openPage(){
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;

    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;

    }

    public RegistrationPage clearLastName(){
        lastNameInput.clear();
        return this;

    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;

    }

    public RegistrationPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;

    }

    public RegistrationPage CookieClose(){
        closeCookie.click();
        return this;

    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;

    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;

    }

    public RegistrationPage verifyResultModalAppears() {
        registrationResultModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);
        return this;
    }






}
