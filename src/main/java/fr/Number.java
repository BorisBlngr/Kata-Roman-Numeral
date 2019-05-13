package fr;

import org.apache.commons.lang3.StringUtils;

class Number {
    private int number;

    Number(int number) {
        this.number = number;
    }

    String numeral() {
        return StringUtils.repeat("I", this.number);
    }
}
