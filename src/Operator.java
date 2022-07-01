public class Operator extends Element {
    String operator;
    public Operator(String operator) {
        this.operator = operator;
    }

    public String makeString() {
        return operator;
    }
}
