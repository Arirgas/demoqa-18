import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class automationPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
    }


    //https://demoqa.com/text-box
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".fc-button.fc-cta-consent.fc-primary-button").click();
        $("#firstName").setValue("Aleksander");
        $("#lastName").setValue("Tumanov");
        $("#userEmail").setValue("Tumanov@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9999999999");
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


        $("[class=table-responsive]").shouldHave(text("Aleksander Tumanov"), text("Tumanov@gmail.com"),
                text("Male"), text("9999999999"), text("28 June,1999"), text("Maths"), text("Sports, Reading, Music"),
                text("1.png"), text("9999999991"),
                text("NCR Delhi"));












    }
}
