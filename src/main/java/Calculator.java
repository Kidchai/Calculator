import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Element> list = new ArrayList<>();

    public Calculator(String input) {
        makeList(input);
        definePriority();
    }

    private void makeList(String input) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String element = Character.toString(input.charAt(i));

            if (Operator.getAllOperators().contains(element)) {
                list.add(new Number(buf.toString()));
                list.add(new Operator(element));
                buf = new StringBuilder();
            } else {
                buf.append(element);
            }
        }
        if (!buf.toString().equals("")) {
            list.add(new Number(buf.toString()));
        }
    }

    private void definePriority() {
        int priority = 1;

        for (int basePriority : new int[]{1, 0}) {
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

    public int calculate() {
        int priorityCounter = 1;
        while (list.size() != 1) {
            for (int i = 0; i < list.size(); i++) {
                Element element = list.get(i);

                if (!(element instanceof Operator operator)) {
                    continue;
                }

                if (operator.getPriority() == priorityCounter) {
                    Number leftElement = (Number) list.get(i - 1);
                    Number rightElement = (Number) list.get(i + 1);

                    list.set(i - 1, operator.execute(leftElement, rightElement));
                    list.remove(i + 1);
                    list.remove(i);
                    priorityCounter++;
                    break;
                }
            }
        }
        return ((Number) list.get(0)).returnValue();
    }
}
