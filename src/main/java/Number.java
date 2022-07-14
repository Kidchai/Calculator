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
            denominator = 10;
        } else {
            numerator = Integer.parseInt(number);
            denominator = 1;
        }
    }

//    public int returnValue() {
//        return number;
//    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator, int denominator) {
        this.numerator = numerator;
    }

    public void setDenominator(int numerator, int denominator) {
        this.denominator = denominator;
    }

//    @Override
//    public boolean equals(Object other) {
//        if (super.equals(other)) return true;
//        if (other == null || other.getClass() != this.getClass()) return false;
//        return returnValue() == ((Number) other).returnValue();
//    }

    @Override
    public String toString() {
        double result = (double) numerator / (double) denominator;
        return String.valueOf(result);
    }
}
