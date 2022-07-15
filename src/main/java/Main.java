import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter the problem and push \"Enter\".");
        Scanner scanner = new Scanner(System.in); //заменить

        while (true) {
            String input = scanner.nextLine();

            Calculator calculator = new Calculator(input);

            System.out.println(calculator.calculate().toString());
        }
    }
}