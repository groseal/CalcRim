public class ConvertRomeToArab {

    public ConvertRomeToArab() {
    }

    private static int letterToNumber(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            default:
                return -1;
        }
    }

    static String convertRomeToArab(String str) {
        str = str.toUpperCase();
        int[] num = new int[str.length()];
        int number;
        for (int i = 0; i < str.length(); i++) {
            number = letterToNumber(str.charAt(i));
            num[i] = number;
        }
        number = 0;
        if (num.length > 1) {
            for (int i = num.length - 1; i > 0; i--) {
                if (num[i - 1] >= num[i]) {
                    number += num[i];
                } else if (num[i - 1] < num[i]) {
                    number += num[i] - num[i - 1];
                    i--;
                }
            }
        }
        if (num.length == 1) {
            return Integer.toString(num[0]);
        } else if (num[0] < num[1]) {
        } else {
            number += num[0];
        }
        return Integer.toString(number);
    }
}

