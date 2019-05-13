package fr;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.repeat;

class Number {
    private int number;

    private Map<Integer, String> romanSymbolMap = new HashMap<Integer, String>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
    }};

    Number(int number) {
        this.number = number;
    }

    String numeral() {
        StringBuilder numeral = new StringBuilder();
        int remainder = this.number;

        remainder = getRemainderAndUpdateNumeralForValue(numeral, remainder, 10);

        remainder = getRemainderAndUpdateNumeralForValue(numeral, remainder, 5);

        getRemainderAndUpdateNumeralForValue(numeral, remainder, 1);

        return numeral.toString();
    }

    private int getRemainderAndUpdateNumeralForValue(StringBuilder numeral, int remainder, int value) {
        int times = remainder / value;

        if (times > 0) {
            numeral.append(repeat(romanSymbolMap.get(value), times));
            remainder -= value * times;
        }

        if (remainder != 0 && remainder % value == value - 1) {
            numeral.append("I")
                    .append(romanSymbolMap.get(value));
            remainder -= value - 1;
        }
        return remainder;
    }
}
