package src.calculator;

import java.util.Scanner;

public class Input {
    private int a;
    private int b;
    private String operator;
    private boolean isRoman;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public String getOperator() {
        return operator;
    }

    public boolean isRoman() {
        return isRoman;
    }

    Input() {
        String input = new Scanner(System.in).nextLine();

        checkInput(input);
        checkOperator(input);
        checkNums(input);
    }

    private void checkInput(String test) {
        String[] array = test.split("\\s+");
        try {
            if (test.isBlank() || array.length != 3) {
                throw new Exception("Wrong input!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private void checkOperator(String test) {
        String[] array = test.split("\\s+");
        try {
            if (!array[1].matches("[+\\-/*]")) {
                throw new Exception("Wrong operator!");
            } else {
                this.operator = array[1];
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private void checkNums(String test) {
        String[] array = test.split("\\s+");
        if (test.matches("([1-9]|10)\\s+([+\\-/*])\\s+([1-9]|10)")) {
            isRoman = false;
            this.a = Integer.parseInt(array[0]);
            this.b = Integer.parseInt(array[2]);
        } else if (checkRom(array[0]) && checkRom(array[2])) {
            isRoman = true;
            this.a = RomanNumber.valueOf(array[0]).getValue();
            this.b = RomanNumber.valueOf(array[2]).getValue();
        } else {
            try {
                throw new Exception("Wrong input!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }

    private boolean checkRom(String test) {
        for (RomanNumber r : RomanNumber.values()) {
            if (r.toString().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
