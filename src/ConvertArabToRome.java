public class ConvertArabToRome {
    static private String[] romanNumerals = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static private String[] arabNumerals = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public ConvertArabToRome() {
    }

    static String convertArabToRome(String number) {
        int num = Integer.parseInt(number);
        StringBuilder value = new StringBuilder("");
        if (Integer.parseInt(number) == 100) {
            return "C";
        }
        if (Integer.parseInt(number) == 0) {
            return "";
        }
        //Десятки
        if (number.length() == 2) {
            for (int j = 0; j < arabNumerals.length; j++) {
                if (Character.toString(number.charAt(0)).equals(arabNumerals[j])) {
                    value.append(romanNumerals[j + 9]);
                    num = num - (num - (num % 10));
                    number = Integer.toString(num);
                    break;
                }
            }
        }
        //Единицы
        for (int i = 0; i < number.length(); i++) {
            for (int j = 0; j < arabNumerals.length; j++) {
                if (Character.toString(number.charAt(i)).equals(arabNumerals[j])) {
                    value.append(romanNumerals[j]);
                }
            }
        }
        return value.toString();
    }
}

