import org.junit.jupiter.api.*;

public class JUnitExamples {

    @BeforeAll

    static void beforeAll() {
        System.out.println("Here is BeforeAll()");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    Here is beforeEach()");
    }

    @AfterAll

    static void AfterAll() {
        System.out.println("Here is AfterAll()");
    }

    @AfterEach
    void AfterEach() {
        System.out.println("Here is AfterEach()");
    }

    @Test
    void firsTest(){
        System.out.println("    Here is firstTest()");
    }
    @Test
    void secondTest(){
        System.out.println("        Here is secondTest()");
    }
}
