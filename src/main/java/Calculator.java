import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Element> list = new ArrayList<>();

    public Calculator(String input) {
        makeList(input);
        definePriority();
    }

    private void makeList(String input) {

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String element = Character.toString(input.charAt(i));

            boolean isElementOperator = Operator.getAllOperators().contains(element);
            boolean isLastListElementNumber = list.size() > 0 && list.get(list.size() - 1) instanceof Number;

            if (element.equals("(")) {
                for (int bracketCount = 1; bracketCount > 0; i++) {
                    element = Character.toString(input.charAt(i + 1));
                    if (element.equals("(")) {
                        bracketCount++;
                    } else if (element.equals(")")) {
                        bracketCount--;
                    }
                    buf.append(element);
                }
                buf.deleteCharAt(buf.length() - 1);

                Calculator calculator = new Calculator(buf.toString());
                buf = new StringBuilder();
                list.add(calculator.calculate());

            } else if (isElementOperator && (buf.length() > 0 || isLastListElementNumber)) {
                if (buf.length() > 0) {
                    list.add(new Number(buf.toString()));
                }
                list.add(new Operator(element));
                buf = new StringBuilder();
            } else {
                buf.append(element);
            }
        }
        if (buf.length() > 0) {
            list.add(new Number(buf.toString()));
        }
    }

    private void definePriority() {
        int priority = 1;

        for (int basePriority : Operator.getBasePriorities()) {
            for (Element element : list) {
                if (!(element instanceof Operator operator)) {
                    continue;
                }

                if (operator.getBasePriority() == basePriority) {
                    operator.setPriority(priority);
                    priority++;
                }
            }
        }
    }

    public Number calculate() {
        int priorityCounter = 1;
        while (list.size() != 1) {
            for (int i = 0; i < list.size(); i++) {
                Element element = list.get(i);

                if (!(element instanceof Operator operator)) {
                    continue;
                }

                if (operator.getPriority() == priorityCounter) {

                    Number leftElement = (Number) list.get(i - 1);
                    Number rightElement = operator.doesNeedRightElement() ? (Number) list.get(i + 1) : null;

                    Number result = operator.execute(leftElement, rightElement);
                    list.set(i - 1, result);

                    if (operator.doesNeedRightElement()) {
                        list.remove(i + 1);
                    }
                    list.remove(i);
                    priorityCounter++;
                    break;
                }
            }
        }
        return (Number) list.get(0);
    }
}
