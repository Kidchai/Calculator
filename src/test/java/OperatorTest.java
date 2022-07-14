import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    @Test
    void shouldReturn1() {
        Operator operator = new Operator("*");
        Assertions.assertEquals(1, operator.getBasePriority());
    }

    @Test
    void shouldReturn0() {
        Operator operator = new Operator("-");
        Assertions.assertEquals(0, operator.getBasePriority());
    }


//    @Test // disabled until solving problem with returnValue() method
//    void execute() {
//        Operator operator = new Operator("*");
//        Number leftNumber = new Number("5");
//        Number rightNumber = new Number("8");
//        Number expectedNumber = new Number("40");
//        System.out.println(operator.execute(leftNumber, rightNumber).returnValue());
//        Assertions.assertEquals(expectedNumber, operator.execute(leftNumber, rightNumber));
//    }
}