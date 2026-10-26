package LAB5.Q19_Calculator;

public class BasicCalculator implements Calculator {
    private int[] values;
    private int top;

    private BasicCalculator() {
        values = new int[2];
        top = 0;
    }

    public static Calculator getInstance() {
        return new BasicCalculator();
    }

    @Override
    public Calculator put(int n) {
        values[top] = n;
        top = (top + 1) % 2;
        return this;
    }

    @Override
    public int read() {
        return values[0];
    }

    @Override
    public Calculator neg() {
        int index = (top + 1) % 2;
        values[index] = -values[index];
        return this;
    }

    @Override
    public Calculator add() {
        values[0] = values[0] + values[1];
        top = 0;
        return this;
    }

    @Override
    public Calculator sub() {
        values[0] = values[0] - values[1];
        top = 0;
        return this;
    }

    @Override
    public Calculator mul() {
        values[0] = values[0] * values[1];
        top = 0;
        return this;
    }

    @Override
    public Calculator div() {
        if (values[1] != 0) {
            values[0] = values[0] / values[1];
        }
        top = 0;
        return this;
    }

    @Override
    public Calculator clear() {
        int index = (top + 1) % 2;
        values[index] = 0;
        top = 0;
        return this;
    }

    @Override
    public Calculator clearAll() {
        values[0] = 0;
        values[1] = 0;
        top = 0;
        return this;
    }
}