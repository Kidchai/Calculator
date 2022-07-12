import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//класс принимает на ввод строку, возвращает число
public class Calculator {
    private List<Element> list = new ArrayList<>();

    public Calculator(String input) {
        makeList(input);
        definePriority();
    }

    private void makeList(String input) {
        String buf = "";
        for (int i = 0; i < input.length(); i++) {
            String element = Character.toString(input.charAt(i));
            if (input.charAt(i) == '+' ||
                    input.charAt(i) == '-' ||
                    input.charAt(i) == '*' ||
                    input.charAt(i) == '/') {
                list.add(new Number(buf));
                list.add(new Operator(element));
                buf = "";
            } else {
                buf += element; //заменить на StringBuilder
            }

            if (i == input.length() - 1) {
                if (!buf.equals("")) {
                    list.add(new Number(buf));
                } else {
                    list.add(new Operator(element));
                }
            }
        }
    }

    private void definePriority() {
        for (Element e : list) {
            if (e instanceof Operator) {
                switch (e.makeString()) {
                    case "*", "/" -> ((Operator) e).setPriority(1);
                    case "-", "+" -> ((Operator) e).setPriority(0);
                }
            }
        }

        Set<Integer> allPriorities = new HashSet<>();
        int priority = 1;
        boolean isPriorityAsserted;

        for (Element e : list) {
            if (e instanceof Operator && ((Operator) e).getPriority() == 1) {
                isPriorityAsserted = false;
                while (!isPriorityAsserted) {
                    if (!allPriorities.contains(priority)) {
                        ((Operator) e).setPriority(priority);
                        allPriorities.add(priority);
                        isPriorityAsserted = true;
                    }
                    priority++;
                }
            }
        }
        for (Element e : list) {
            if (e instanceof Operator && ((Operator) e).getPriority() == 0) {
                isPriorityAsserted = false;
                while (!isPriorityAsserted) {
                    if (!allPriorities.contains(priority)) {
                        ((Operator) e).setPriority(priority);
                        allPriorities.add(priority);
                        isPriorityAsserted = true;
                    }
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
                if (element instanceof Operator && ((Operator) element).getPriority() == priorityCounter) {
                    Element leftElement = list.get(i - 1);
                    Element rightElement = list.get(i + 1);
                    int leftNumber = ((Number) leftElement).returnValue();
                    int rightNumber = ((Number) rightElement).returnValue();
                    int result = 0;
                    switch (element.makeString()) {
                        case "*" -> result = leftNumber * rightNumber;
                        case "/" -> result = leftNumber / rightNumber;
                        case "+" -> result = leftNumber + rightNumber;
                        case "-" -> result = leftNumber - rightNumber;
                    }
                    list.set(list.indexOf(leftElement), new Number(result));
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
