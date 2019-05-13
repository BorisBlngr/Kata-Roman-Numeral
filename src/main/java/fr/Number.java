package fr;

import static org.apache.commons.lang3.StringUtils.repeat;

class Number {
    private int number;

    Number(int number) {
        this.number = number;
    }

    String numeral() {
        if (this.number == 5) {
            return "V";
        }
        return repeat("I", this.number);
    }
}
