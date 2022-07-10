import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter the problem and push \"Enter\".");
        while (true) {
            Scanner scanner = new Scanner(System.in); //заменить
            String input = scanner.nextLine();

            Calculator calculator = new Calculator();
            calculator.makeList(input);
            calculator.definePriority();

            System.out.println(calculator.calculate());
        }
    }
}