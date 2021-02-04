public class Parser {
    private String str = "";
    private String firstDigit;
    private String secondDigit;
    private char mathematicalOperation;

    public String getFirstDigit() {
        return firstDigit;
    }

    public String getSecondDigit() {
        return secondDigit;
    }

    public char getMathematicalOperation() {
        return mathematicalOperation;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int isNotation(String str) {//0 - arab, 1 - roma, -1 - error
        String arab = "0123456789";
        String roma = "IVXLCivxlc";
        int sumA = 0;
        int sumR = 0;
        for (int i = 0; i < str.length(); i++) {
            if (arab.contains(Character.toString(str.charAt(i)))) {
                sumA += 1;
            } else if (roma.contains(Character.toString(str.charAt(i)))) {
                sumR += 1;
            } else return -1;
        }
        if (sumR == str.length()) {
            return 1;
        } else if (sumA == str.length()) {
            return 0;
        }
        return -1;
    }

    void parse() {
        String[] example = str.split("[+\\-\\*\\/]");
        try {
            example[0] = example[0].trim();
            example[1] = example[1].trim();
        }catch (Exception e){
            System.out.println("Неверный ввод.");
        }
        firstDigit = example[0];
        secondDigit = example[1];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' ||
                    str.charAt(i) == '-' ||
                    str.charAt(i) == '*' ||
                    str.charAt(i) == '/') {
                mathematicalOperation = str.charAt(i);
                break;
            }
        }
    }
}



