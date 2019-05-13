package fr;

import static org.apache.commons.lang3.StringUtils.repeat;

class Number {
    private int number;

    Number(int number) {
        this.number = number;
    }

    String numeral() {
        StringBuilder numeral = new StringBuilder();
        int remainder = this.number;
        if (this.number > 8) {
            numeral.append("IX");
            remainder -= 9;
        }

        if (remainder / 5 > 0) {
            numeral.append("V");
            remainder -= 5;
        }

        if (remainder < 5 && remainder % 5 == 4) {
            numeral.append("IV");
            remainder -= 4;
        }
        numeral.append(repeat("I", remainder));

        return numeral.toString();
    }
}
