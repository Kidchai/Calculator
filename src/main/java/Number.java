public class Number extends Element {
    private final Integer numerator;
    private final Integer denominator;

    public Number(String number) {
        if (number.contains(".")) {
            String[] array = number.split("\\.");
            numerator = Integer.parseInt(array[0]) * 10 + Integer.parseInt(array[1]);
            denominator = (int) Math.pow(10, array[1].length());
        } else {
            numerator = Integer.parseInt(number);
            denominator = 1;
        }
    }

    public Number(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        double result = (double) numerator / (double) denominator;

        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }
}