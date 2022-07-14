import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operator extends Element {
    String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    private int priority;

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        return operator;
    }

    public int getBasePriority() {
        int basePriority = 0;
        switch (operator) {
            case "*":
            case "/":
                basePriority = 1;
                break;
            case "-":
            case "+":
                break;
        }
        return basePriority;
    }
    
    public Number execute(Number left, Number right) {
//        int leftNumber = left.returnValue();
//        int rightNumber = right.returnValue();

        return switch (operator) {
            case "+" -> add(left, right);
            case "-" -> subtract(left, right);
            case "*" -> multiply(left, right);
            case "/" -> divide(left, right);
            default -> new Number("");
        };
    }

    private Number add(Number left, Number right) {
        int leftNumerator = left.getNumerator();
        int leftDenominator = left.getDenominator();
        int rightNumerator = right.getNumerator();
        int rightDenominator = right.getDenominator();

        int resultNumerator = 0;
        int resultDenominator = 0;

        if (leftDenominator == rightDenominator) {
            resultNumerator = leftNumerator + rightNumerator;
            resultDenominator = leftDenominator;
        }
        return new Number(resultNumerator, resultDenominator);
    }

    private Number subtract(Number left, Number right) {
        int leftNumerator = left.getNumerator();
        int leftDenominator = left.getDenominator();
        int rightNumerator = right.getNumerator();
        int rightDenominator = right.getDenominator();

        int resultNumerator = 0;
        int resultDenominator = 0;

        if (leftDenominator == rightDenominator) {
            resultNumerator = leftNumerator - rightNumerator;
            resultDenominator = leftDenominator;
        }
        return new Number(resultNumerator, resultDenominator);
    }

    private Number multiply(Number left, Number right) {
        int leftNumerator = left.getNumerator();
        int leftDenominator = left.getDenominator();
        int rightNumerator = right.getNumerator();
        int rightDenominator = right.getDenominator();

        int resultNumerator = leftNumerator * rightNumerator;
        int resultDenominator = leftDenominator * rightDenominator;

        return new Number(resultNumerator, resultDenominator);
    }

    private Number divide(Number left, Number right) {
        int leftNumerator = left.getNumerator();
        int leftDenominator = left.getDenominator();
        int rightNumerator = right.getDenominator();
        int rightDenominator = right.getNumerator();

        int resultNumerator = leftNumerator * rightNumerator;
        int resultDenominator = leftDenominator * rightDenominator;

        return new Number(resultNumerator, resultDenominator);
    }

    public static List<String> getAllOperators() {
        return Arrays.asList("+", "-", "*", "/");
    }
}
