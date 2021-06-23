package src.calculator;

import java.util.Collections;

public class Calculator {
    private final int a;
    private final int b;
    private final String operator;
    private String result;

    public Calculator(Input input) {
        this.a = input.getA();
        this.b = input.getB();
        this.operator = input.getOperator();
        this.result = getResult(input.isRoman());
        outputResult(input.isRoman());
    }

    private int sum() {
        return this.a + this.b;
    }

    private int sub() {
        return a - b;
    }

    private int mul() {
        return a * b;
    }

    private double divDouble() {
        return 1.0 * a / b;
    }

    private int divInteger() {
        return a / b;
    }

    private String getResult(boolean isRoman) {
        switch (operator) {
            case "+":
                return sum() + "";
            case "*":
                return mul() + "";
            case "-":
                return sub() + "";
            case "/":
                if (isRoman) {
                    return divInteger() + "";
                } else {
                    return divDouble() + "";
                }
            default:
                return "";
        }
    }

    void outputResult(boolean isRoman) {
        if (isRoman && result.equals("0")) {
            System.out.println(RomanNumber.N);
        } else if (isRoman) {
            String sign = result.substring(0, 1);
            if (sign.equals("-")) {
                result = result.substring(1);
            } else {
                sign = "";
            }
            System.out.println(sign + transRoman(result));
        } else {
            System.out.printf("%.4s", result);
        }
    }

    private String transRoman(String result) {
        return String.join("", Collections.nCopies(Integer.parseInt(result), "I"))
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC");
    }

}
