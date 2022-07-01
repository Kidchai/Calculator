import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter the problem and push \"Enter\".");
            while (true) {
                String input = "";
                //long result = 0;
                ArrayList<Element> list = new ArrayList<>();
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

                for (Element e: list) {
                    System.out.print(e.makeString() + " ");
                }
                System.out.println("");


//            if (input.contains("+")) {
//                String[] array = input.split("\\+");
//                result = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
//            } else if (input.contains("-")) {
//                String[] array = input.split("-");
//                result = Integer.parseInt(array[0]) - Integer.parseInt(array[1]);
//            } else if (input.contains("*")) {
//                String[] array = input.split("\\*");
//                result = (long) Integer.parseInt(array[0]) * Integer.parseInt(array[1]);
//            } else if (input.contains("/")) {
//                String[] array = input.split("/");
//                result = Integer.parseInt(array[0]) / Integer.parseInt(array[1]);
//            }
//            System.out.println(result);

            //1+2-4*4
        }
    }
}
