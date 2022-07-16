import java.util.Arrays;
import java.util.List;

public class Operator extends Element {
    String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    private int priority;

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

    public static List<String> getAllOperators() {
        return Arrays.asList("+", "-", "*", "/", "!");
    }
}
