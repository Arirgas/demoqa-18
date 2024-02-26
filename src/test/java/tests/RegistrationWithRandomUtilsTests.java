package tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;


public class RegistrationWithRandomUtilsTests extends TestBase {

    String userName = getRandomString(10),
            lastName = getRandomString(10),
            email = getRandomEmail();


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
        $("#currentAddress").setValue("9999999991");
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
                text("1.png"), text("9999999991"),
                text("NCR Delhi"));












    }
}
