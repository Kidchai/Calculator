import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1=1",
            "2!=4", //fix it after updating factorial
            "-1+1=0",
            "-4*-4=16",
            "3*(2+5)=21",
            "5+7-5*2=2",
            "3-5/2=0.5",
            "10/3*3=10",
            "5/2+7=9.5",
    }, delimiter = '=')
    void test(String input, String expected) {
        var calculator = new Calculator(input);
        String actual = calculator.calculate().toString();
        Assertions.assertEquals(expected, actual);
    }
}