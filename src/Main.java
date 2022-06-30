import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	System.out.println("Please enter the problem and push \"Enter\".");
        while (true) {
            String input = "";
            long result = 0;
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();

            if (input.contains("+")) {
                String[] array = input.split("\\+");
                result = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
            } else if (input.contains("-")) {
                String[] array = input.split("-");
                result = Integer.parseInt(array[0]) - Integer.parseInt(array[1]);
            } else if (input.contains("*")) {
                String[] array = input.split("\\*");
                result = (long) Integer.parseInt(array[0]) * Integer.parseInt(array[1]);
            } else if (input.contains("/")) {
                String[] array = input.split("/");
                result = Integer.parseInt(array[0]) / Integer.parseInt(array[1]);
            }
            System.out.println(result);
        }
    }
}
