package fr;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.repeat;

class Numeral {
    private Map<Integer, String> romanSymbolMap = new HashMap<Integer, String>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
    }};
    private final int number;
    private final StringBuilder numeral = new StringBuilder();

    Numeral(int number) {
        this.number = number;
        this.buildNumeral();
    }

    private void buildNumeral() {
        int remainder = this.number;

        remainder = getRemainderAndUpdateNumeralForValue(remainder, tenPower(2), tenPower(1));
        remainder = getRemainderAndUpdateNumeralForValue(remainder, 5 * tenPower(1), tenPower(1));

        remainder = getRemainderAndUpdateNumeralForValue(remainder, tenPower(1), tenPower(0));
        remainder = getRemainderAndUpdateNumeralForValue(remainder, 5 * tenPower(0), tenPower(0));

        getRemainderAndUpdateNumeralForValue(remainder, 1, 1);
    }

    private int tenPower(int power) {
        return (int) Math.pow(10, power);
    }

    String print() {
        return numeral.toString();
    }

    private int getRemainderAndUpdateNumeralForValue(int remainder, int value, int previousValue) {
        int times = remainder / value;

        if (times > 0) {
            updateNumeral(repeat(romanSymbolMap.get(value), times));
            remainder -= value * times;
        }

        if (remainder != 0 && remainder % value == value - previousValue) {
            updateNumeral(romanSymbolMap.get(previousValue) + romanSymbolMap.get(value));
            remainder -= value - previousValue;
        }
        return remainder;
    }

    private void updateNumeral(String string) {
        this.numeral.append(string);
    }
}
