package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="2560x1440";

    }

    @Test
    void andreiSolncev(){

        // Открыть страницу репозитория selenide
        open("https://github.com/selenide/selenide");
        // Подвести мышку к первому аватару из блока contributors
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();
        // проверка: во всплывающем окне есть текст Andrei Solntsev
        $("[data-hydro-view-hmac=f1d2880c497337bf4a1463ff8c658dc5507c77f637411a7b7b08c585a0175309]").shouldHave(text("Andrei Solntsev"));






    }

}
