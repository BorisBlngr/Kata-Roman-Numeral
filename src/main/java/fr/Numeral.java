package fr;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.repeat;

class Numeral {
    private final int number;
    private final StringBuilder numeral = new StringBuilder();

    private Map<Integer, String> romanSymbolMap = new HashMap<Integer, String>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
    }};

    Numeral(int number) {
        this.number = number;
        buildNumeral();
    }

    String print() {
        return numeral.toString();
    }

    private void buildNumeral() {
        int remainder = this.number;

        remainder = getRemainderAndUpdateNumeralForValue(remainder, 10);
        remainder = getRemainderAndUpdateNumeralForValue(remainder, 5);
        getRemainderAndUpdateNumeralForValue(remainder, 1);
    }

    private int getRemainderAndUpdateNumeralForValue(int remainder, int value) {
        int times = remainder / value;

        if (times > 0) {
            this.numeral.append(repeat(romanSymbolMap.get(value), times));
            remainder -= value * times;
        }

        if (remainder != 0 && remainder % value == value - 1) {
            this.numeral.append(romanSymbolMap.get(1))
                    .append(romanSymbolMap.get(value));
            remainder -= value - 1;
        }
        return remainder;
    }
}
