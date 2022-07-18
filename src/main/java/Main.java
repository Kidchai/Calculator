import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter the problem and push \"Enter\".");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            while (true) {
                try {
                    String input = reader.readLine();
                    Calculator calculator = new Calculator(input);
                    System.out.println(calculator.calculate().toString());
                } catch (Exception e) {
                    System.err.println("Something went wrong. Please, try again.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}