import java.util.Arrays;
import java.util.List;

public class Operator extends Element {
    String operator;
    private int priority;

    public Operator(String operator) {
        this.operator = operator;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public int getBasePriority() {
        return switch (operator) {
            case "!" -> 1;
            case "*", "/" -> 2;
            case "-", "+" -> 3;
            default -> 0;
        };
    }

    public boolean doesNeedRightElement() {
        return !operator.equals("!");
    }

    public Number execute(Number left, Number right) {
        Operation operation = new Operation(left, right);

        return switch (operator) {
            case "+" -> operation.add();
            case "-" -> operation.subtract();
            case "*" -> operation.multiply();
            case "/" -> operation.divide();
            case "!" -> operation.findFactorial();
            default -> new Number("");
        };
    }

    public static List<String> getAllOperators() {
        return Arrays.asList("+", "-", "*", "/", "!");
    }
}
