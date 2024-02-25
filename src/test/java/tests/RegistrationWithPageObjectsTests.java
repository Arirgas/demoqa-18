package tests;


import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationWithPageObjectsTests extends TestBase {



    //https://demoqa.com/text-box
    @Test
    void fillFormTest() {
        String userName = "Aleksandr";

        registrationPage.openPage()
                .CookieClose() // Закрытие уведомления о сборе куки
                .setFirstName(userName)
                .setLastName("Tumanov")
                .setEmail("Tumanov@gmail.com")
                .setGender("Male")
                .setUserNumber("9999999999")
                .setBirthDate("28", "June", "1999");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1999");
        // $(byText("28")).click(); - bad variantK
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
                .verifyResult("Student Name", userName + " Tumanov")
                .verifyResult("Student Email", "Tumanov@gmail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile","9999999999")
                .verifyResult("Date of Birth", "28 June,1999");
            $(".table-responsive").shouldHave(text("Aleksandr Tumanov"), text("Tumanov@gmail.com"),
                text("Male"), text("9999999999"), text("28 June,1999"), text("Maths"), text("Sports, Reading, Music"),
                text("1.png"), text("9999999991"),
                text("NCR Delhi"));












    }
}
