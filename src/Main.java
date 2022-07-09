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
            //long result = 0;
            Scanner scanner = new Scanner(System.in);
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
                    buf += element;
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

            for (Element e : list) {
                System.out.print(e.makeString() + " ");
            }
            System.out.println("");
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
        boolean isPriorityAsserted = false;

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
}