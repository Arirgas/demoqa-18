import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {
        //data-testid
        $("[data-testid=email]").setValue("1");
        $(by("data-testid","email")).setValue("1");

        //id
        $("#email").setValue("1");
        $x("//*[@id='email']").setValue("1");
        //name
        $("[name=email]").setValue("1");
        $(byName("email")).setValue("1");
        // class
        $(".fc-button.fc-cta-consent.fc-primary-button").click();


        //text
        // <div>Hello, qa.guru</div>

         $x("//div[text()='Hello, qa.guru']").click();
         $(byText("Hello, qa.guru"));
         $(withText("llo, qa.guru"));


    }
}
