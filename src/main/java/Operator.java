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
                basePriority = 0;
                break;
        }
        return basePriority;
    }
    
    public Number execute(Number left, Number right) {
        int leftNumber = left.returnValue();
        int rightNumber = right.returnValue();
        int result = 0;
        switch (operator) {
            case "*" -> result = leftNumber * rightNumber;
            case "/" -> result = leftNumber / rightNumber;
            case "+" -> result = leftNumber + rightNumber;
            case "-" -> result = leftNumber - rightNumber;
        }
        return new Number(result);
    }

    public static List<String> getAllOperators() {
        return Arrays.asList("+", "-", "*", "/");
    }
}
