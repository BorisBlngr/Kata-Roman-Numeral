package fr;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.repeat;

class NumeralFactory {
    private Map<Integer, String> romanSymbolMap = new HashMap<Integer, String>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
    }};
    private int remainder;
    private final StringBuilder numeral = new StringBuilder();

    NumeralFactory() {
    }

    NumeralFactory(Map<Integer, String> romanSymbolMap) {
        this.romanSymbolMap = romanSymbolMap;
    }

    String of(int number) {
        remainder = number;

        buildNumeral();

        return numeral.toString();
    }

    private void buildNumeral() {
        int times = romanSymbolMap.size() > 3 ? romanSymbolMap.size() / 3 + 2 : romanSymbolMap.size();

        for (int index = times; index > 0; index--) {
            updateRemainderAndNumeralForValue(tenPower(index), tenPower(index - 1));
            updateRemainderAndNumeralForValue(5 * tenPower(index - 1), tenPower(index - 1));
        }
        updateRemainderAndNumeralForValue(1, 1);
    }

    private int tenPower(int power) {
        return (int) Math.pow(10, power);
    }

    private void updateRemainderAndNumeralForValue(int value, int previousValue) {
        int times = remainder / value;

        if (times > 0) {
            updateNumeral(repeat(romanSymbolMap.get(value), times));
            subtractRemainderBy(value * times);
        }

        if (remainder != 0 && remainder % value == value - previousValue) {
            updateNumeral(romanSymbolMap.get(previousValue) + romanSymbolMap.get(value));
            subtractRemainderBy(value - previousValue);
        }
    }

    private void subtractRemainderBy(int value) {
        remainder -= value;
    }

    private void updateNumeral(String string) {
        this.numeral.append(string);
    }
}
