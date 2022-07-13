public class Number extends Element {
    Integer number;

    public Number(String number) {
        this.number = Integer.parseInt(number);
    }

    public Number(int number) {
        this.number = number;
    }

//    public String toString() {
//        return number.toString();
//    }

    public int returnValue() {
        return number;
    }

    @Override
    public boolean equals(Object other) {
        if (super.equals(other)) return true;
        if (other == null || other.getClass() != this.getClass()) return false;
        return returnValue() == ((Number) other).returnValue();
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
