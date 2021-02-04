import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите в консоль пример для вычисления и нажмите Enter.");
        String str = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parser example = new Parser();
        example.setStr(str);
        example.parse();

        Сalculator calc = new Сalculator();
        int numA = example.isNotation(example.getFirstDigit());
        int numB = example.isNotation(example.getSecondDigit());

        if (numA == numB && numA == 0) {
            numA = Integer.parseInt(example.getFirstDigit());
            numB = Integer.parseInt(example.getSecondDigit());
            if (numA > 0 && numA < 11 && numB > 0 && numB < 11) {
                if (example.getMathematicalOperation() == '+') {
                    System.out.println(Сalculator.addition(numA, numB));
                } else if (example.getMathematicalOperation() == '-') {
                    System.out.println(Сalculator.subtraction(numA, numB));
                } else if (example.getMathematicalOperation() == '*') {
                    System.out.println(Сalculator.multiplication(numA, numB));
                } else if (example.getMathematicalOperation() == '/') {
                    System.out.println(Сalculator.division(numA, numB));
                }
            } else {
                try {
                    throw new Exception("Ошибка ввода");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else if (numA == numB && numA == 1) {
            numA = Integer.parseInt(ConvertRomeToArab.convertRomeToArab(example.getFirstDigit()));
            numB = Integer.parseInt(ConvertRomeToArab.convertRomeToArab(example.getSecondDigit()));
            String res;
            if (numA > 0 && numA < 11 && numB > 0 && numB < 11) {
                if (example.getMathematicalOperation() == '+') {
                    res = Integer.toString(Сalculator.addition(numA, numB));
                    System.out.println(ConvertArabToRome.convertArabToRome(res));
                } else if (example.getMathematicalOperation() == '-') {
                    res = Integer.toString(Сalculator.subtraction(numA, numB));
                    if (Integer.parseInt(res) > 0) {
                        System.out.println(ConvertArabToRome.convertArabToRome(res));
                    } else {
                        try {
                            throw new Exception("Ошибка: отрицательное римское число.");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (example.getMathematicalOperation() == '*') {
                    res = Integer.toString(Сalculator.multiplication(numA, numB));
                    System.out.println(ConvertArabToRome.convertArabToRome(res));
                } else if (example.getMathematicalOperation() == '/') {
                    res = Integer.toString(Сalculator.division(numA, numB));
                    System.out.println(ConvertArabToRome.convertArabToRome(res));
                }
            } else {
                try {
                    throw new Exception("Ошибка ввода");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                throw new Exception("Ошибка ввода");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

