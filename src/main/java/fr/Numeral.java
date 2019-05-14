package fr;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.repeat;

class Numeral {
    private Map<Integer, String> romanSymbolMap = new HashMap<Integer, String>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
    }};
    private final int number;
    private final StringBuilder numeral = new StringBuilder();

    Numeral(int number) {
        this.number = number;
    }

    String print() {
        buildNumeral();
        return numeral.toString();
    }

    private void buildNumeral() {
        int remainder = this.number;

        List<Integer> numbers = getReverseSortedKey();

        remainder = getRemainderAndUpdateNumeralForValue(remainder, 50, 10);

        remainder = getRemainderAndUpdateNumeralForValue(remainder, 10, 1);
        remainder = getRemainderAndUpdateNumeralForValue(remainder, 5, 1);

        getRemainderAndUpdateNumeralForValue(remainder, 1, 1);

    }

    private List<Integer> getReverseSortedKey() {
        return romanSymbolMap.keySet()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private int getRemainderAndUpdateNumeralForValue(int remainder, int value, int previousValue) {
        int times = remainder / value;

        if (times > 0) {
            this.numeral.append(repeat(romanSymbolMap.get(value), times));
            remainder -= value * times;
        }

        if (remainder != 0 && remainder % value == value - previousValue) {
            this.numeral.append(romanSymbolMap.get(previousValue))
                    .append(romanSymbolMap.get(value));
            remainder -= value - previousValue;
        }
        return remainder;
    }
}
