package tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;


public class RegistrationWithFakerTests extends TestBase {
    Faker faker = new Faker();


    String userName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            currentAddress = faker.address().fullAddress();


    @Test
    void fillFormTest() {


        registrationPage.openPage()
                .CookieClose() // Закрытие уведомления о сборе куки
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male")
                .setUserNumber("9999999999")
                .setBirthDate("28", "June", "1999");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click(); // good variant
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(currentAddress);
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $(byText("Submit")).click();


        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile","9999999999")
                .verifyResult("Date of Birth", "28 June,1999");
            $(".table-responsive").shouldHave(text("Maths"), text("Sports, Reading, Music"),
                text("1.png"), text(currentAddress),
                text("NCR Delhi"));












    }
}
