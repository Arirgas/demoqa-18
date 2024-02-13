import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class textbox {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
    }


    //https://demoqa.com/text-box
    @Test
    void fillFormTest() {
        open("/text-box");
        $(".fc-button.fc-cta-consent.fc-primary-button").click();
        $("#userName").setValue("Alex Tumanov");
        $("#userEmail").setValue("aaabbb@gmail.com");
        $("#currentAddress").setValue("Pushkina1");
        $("#permanentAddress").setValue("Pushkina2");
        $("#submit").click();
        $("#output").shouldHave(text("Alex Tumanov"), text("aaabbb@gmail.com"), text("Pushkina1"), text("Pushkina2"));
    }
}

