public class Operation {
    int leftNumerator;
    int leftDenominator;
    int rightNumerator;
    int rightDenominator;

    public Number execute(String operator, Number left, Number right) {
        leftNumerator = left.getNumerator();
        leftDenominator = left.getDenominator();
        rightNumerator = right.getNumerator();
        rightDenominator = right.getDenominator();

        return switch (operator) {
            case "+" -> add();
            case "-" -> subtract();
            case "*" -> multiply();
            case "/" -> divide();
            default -> new Number("");
        };
    }

    public Number execute(String operator, Number number) {
        return switch (operator) {
            case "!" ->  findFactorial(number);
            default -> new Number("");
        };
    }

    private Number add() {
        if (leftDenominator != rightDenominator) {
            setCommonDenominator();
        }
        return new Number(leftNumerator + rightNumerator, leftDenominator);
    }

    private Number subtract() {
        if (leftDenominator != rightDenominator) {
            setCommonDenominator();
        }
        return new Number(leftNumerator - rightNumerator, leftDenominator);
    }

    private Number multiply() {
        return new Number(leftNumerator * rightNumerator, leftDenominator * rightDenominator);
    }

    private Number divide() {
        return new Number(leftNumerator * rightDenominator, leftDenominator * rightNumerator);
    }

    private Number findFactorial(Number number) {
        int result = number.getNumerator() * 2; //change

        return new Number(result, 1);
    }

    private void setCommonDenominator() {
        int commonDenominator = findCommonDenominator(leftDenominator, rightDenominator);

        leftNumerator = commonDenominator / leftDenominator * leftNumerator;
        rightNumerator = commonDenominator / rightDenominator * rightNumerator;
        leftDenominator = commonDenominator;
    }

    private int findCommonDenominator(int left, int right) {
        int multiplication = left * right;
        int buf;

        if (left < right) {
            int tmp = left;
            left = right;
            right = tmp;
        }
        while (right != 0) {
            buf = left % right;
            left = right;
            right = buf;
        }
        return multiplication / left;
    }
}
