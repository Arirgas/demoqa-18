package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="2560x1440";

    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        // Открыть главную страницу
        open("https://github.com/");
        // Ввести в поле поиска selenide и нажать enter
        $("[placeholder='Search or jump to...']").click();
        $("[aria-controls='query-builder-test-results']").setValue("selenide").pressEnter();
        // Кликнуть на первый репозиторий из списка найденных
        $("[class='Text-sc-17v1xeu-0 qaOIC search-match']").click();
        sleep(5000);
        // Проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));



    }

}
