import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static ArrayList<Element> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Please enter the problem and push \"Enter\".");
        while (true) {
            String input = "";
            Scanner scanner = new Scanner(System.in); //заменить
            input = scanner.nextLine();
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

            Main.definePriority();
            System.out.println(Main.calculate());
        }
    }

    private static void definePriority() {
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

    private static int calculate() {
        int priorityCounter = 1;
        while (list.size() != 1) {
            for (int i = 0; i < list.size(); i++) {
                Element element = list.get(i);
                if (element instanceof Operator && ((Operator) element).getPriority() == priorityCounter) {
                    Element leftElement = list.get(i - 1);
                    Element rightElement = list.get(i + 1);
                    int leftNumber = Integer.parseInt((leftElement).makeString());
                    int rightNumber = Integer.parseInt((rightElement).makeString());
                    int result = 0;
                    switch (element.makeString()) {
                        case "*" -> result = leftNumber * rightNumber;
                        case "/" -> result = leftNumber / rightNumber;
                        case "+" -> result = leftNumber + rightNumber;
                        case "-" -> result = leftNumber - rightNumber;
                    }
                    list.set(list.indexOf(leftElement), new Number(String.valueOf(result)));
                    list.remove(i + 1);
                    list.remove(i);
                    priorityCounter++;
                    break;
                }
            }
        }
        return Integer.parseInt(list.get(0).makeString());
    }
}