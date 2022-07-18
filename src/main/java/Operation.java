public class Operation {
    int leftNumerator;
    int leftDenominator;
    int rightNumerator;
    int rightDenominator;

    public Operation(Number left, Number right) {
        if (left != null) {
            this.leftNumerator = left.getNumerator();
            this.leftDenominator = left.getDenominator();
        }

        if (right != null) {
            this.rightNumerator = right.getNumerator();
            this.rightDenominator = right.getDenominator();
        }
    }

    public Number add() {
        setCommonDenominator();
        return new Number(leftNumerator + rightNumerator, leftDenominator);
    }

    public Number subtract() {
        setCommonDenominator();
        return new Number(leftNumerator - rightNumerator, leftDenominator);
    }

    public Number multiply() {
        return new Number(leftNumerator * rightNumerator, leftDenominator * rightDenominator);
    }

    public Number divide() {
        return new Number(leftNumerator * rightDenominator, leftDenominator * rightNumerator);
    }

    public Number findFactorial() {
        int result = leftNumerator * 2; //change

        return new Number(result, 1);
    }

    private void setCommonDenominator() {
        if (leftDenominator == rightDenominator) {
            return;
        }
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
