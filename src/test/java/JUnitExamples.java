import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JUnitExamples {

    @BeforeAll

    static void beforeAll() {
        System.out.println("Here is BeforeAll()");
    }
    @Test
    void firsTest(){
        System.out.println("Here is firstTest()");
    }
    @Test
    void secondTest(){
        System.out.println("Here is secondTest()");
    }
}
