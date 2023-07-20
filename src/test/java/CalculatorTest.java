import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1=1",
            "-1+1=0",
            "(5)+4=9",
            "1+(((5))+(4))=10",
            "-4*-4=16",
            "3.2-2.4=0.8",
            "3*(2+5)=21",
            "3-5/2=0.5",
    }, delimiter = '=')
    void test(String input, String expected) {
        var calculator = new Calculator(input);
        String actual = calculator.calculate().toString();
        Assertions.assertEquals(expected, actual);
    }
}