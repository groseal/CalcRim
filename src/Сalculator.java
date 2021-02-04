public class Сalculator {

    public Сalculator() {
    }

    static int addition(int a, int b) {
        return a + b;
    }

    static int subtraction(int a, int b) {
        return a - b;
    }

    static int multiplication(int a, int b) {
        return a * b;
    }

    static int division(int a, int b) {
        if (a == 0 || b == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        } else return a / b;
    }
}
