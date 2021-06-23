package src.calculator;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        //System.out.printf("%s %s%n", input.getA(), input.getB());
        new Calculator(input);
        //calculator.outputResult(input.isRoman());
    }
}

