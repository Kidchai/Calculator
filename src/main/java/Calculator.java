import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Element> list = new ArrayList<>();

    public Calculator(String input) {
        makeList(input);
        definePriority();
    }

    private void makeList(String input) {
        if (input.contains("(")) {
            String subString = input.substring(input.indexOf('(') + 1, input.indexOf(')'));
            Calculator calculator = new Calculator(subString);
            String result = calculator.calculate().toString();
            StringBuilder stringBuilder = new StringBuilder(input);
            stringBuilder.replace(stringBuilder.indexOf("("), input.indexOf(")") + 1, result);
            input = stringBuilder.toString();
        }

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String element = Character.toString(input.charAt(i));

            if (Operator.getAllOperators().contains(element) && buf.length() > 0) {
                Number number = new Number(buf.toString());
                list.add(number);
                list.add(new Operator(element));
                buf = new StringBuilder();
            } else {
                buf.append(element);
            }
        }
        if (buf.length() > 0) {
            Number number = new Number(buf.toString());
            list.add(number);
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
