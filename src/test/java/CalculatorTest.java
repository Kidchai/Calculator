import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"5+7-5*2=2", "2-5=-3"}, delimiter = '=')
    void test(String input, String expected) {
        var calculator = new Calculator(input);
        String actual = calculator.calculate().toString();
        Assertions.assertEquals(expected, actual);
    }
}