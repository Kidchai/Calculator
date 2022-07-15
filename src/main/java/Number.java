public class Number extends Element {
    String number;
    private Integer numerator;
    private Integer denominator;

    public Number(String number) {
        this.number = number;
    }

//    public Number(int number) {
//        this.number = number;
//    }

//    public Number(String numerator, String denominator) {
//        this.numerator = Integer.parseInt(numerator);
//        this.denominator = Integer.parseInt(denominator);
//    }

    public Number(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void convertToFraction() {
        if (number.contains(".")) {
            String[] array = number.split("\\.");
            numerator = Integer.parseInt(array[0]) * 10 + Integer.parseInt(array[1]);
            denominator = (int)  Math.pow(10, array[1].length());
        } else {
            numerator = Integer.parseInt(number);
            denominator = 1;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public boolean equals(Object other) {
        if (super.equals(other)) return true;
        if (other == null || other.getClass() != getClass()) return false;
        return toString().equals(other.toString());
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