import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operator extends Element {
    String operator;
    private int priority;
    private static Map<String, Integer> basePriorities = Stream.of(
                    new AbstractMap.SimpleEntry<>("*", 1),
                    new AbstractMap.SimpleEntry<>("/", 2),
                    new AbstractMap.SimpleEntry<>("-", 3),
                    new AbstractMap.SimpleEntry<>("+", 3))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

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
        return basePriorities.get(operator);
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
            default -> new Number("");
        };
    }

    public static Set<String> getAllOperators() {
        return basePriorities.keySet();
    }
}
