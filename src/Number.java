public class Number extends Element {
    Integer number;
    public Number(String number) {
        this.number = Integer.parseInt(number);
    }

    public String makeString() {
        return number.toString();
    }
}
