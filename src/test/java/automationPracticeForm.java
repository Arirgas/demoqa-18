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
        $(".react-datepicker__year-select").click();
        $(byText("1999")).click();
        $(byText("28")).click();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("C:\\Users\\Alexander\\Desktop\\LUTZZZZ.png"));
        $("#currentAddress").setValue("9999999991");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $(byText("Submit")).click();


        $("[class=table-responsive]").shouldHave(text("Aleksander Tumanov"), text("Tumanov@gmail.com"),
                text("Male"), text("9999999999"), text("28 June,1999"), text("Sports, Reading, Music"),
                text("LUTZZZZ.png"), text("9999999991"),
                text("NCR Delhi"));












    }
}
