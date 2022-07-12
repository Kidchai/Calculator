public class Number extends Element {
    Integer number;

    public Number(String number) {
        this.number = Integer.parseInt(number);
    }

    public Number(int number) {
        this.number = number;
    }

    public String makeString() {
        return number.toString();
    }

    public int returnValue() {
        return number;
    }
}
