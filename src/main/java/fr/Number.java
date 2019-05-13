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

        if (this.number / 5 > 0) {
            numeral.append("V");
            remainder -= 5;
        }
        numeral.append(repeat("I", remainder));

        return numeral.toString();
    }
}
