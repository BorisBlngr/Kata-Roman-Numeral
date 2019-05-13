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
        if (remainder % 10 == 10 - 1) {
            numeral.append("I" + "X");
            remainder -= 10 - 1;
        }

        if (remainder / 5 > 0) {
            numeral.append("V");
            remainder -= 5;
        }

        if (remainder % 5 == 5 - 1) {
            numeral.append("I" + "V");
            remainder -= 5 - 1;
        }
        numeral.append(repeat("I", remainder));

        return numeral.toString();
    }
}
