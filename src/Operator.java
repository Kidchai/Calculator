public class Operator extends Element {
    String operator;
    public Operator(String operator) {
        this.operator = operator;
    }

    private int priority;

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {return priority;}

    public String makeString() {
        return operator;
    }
}
