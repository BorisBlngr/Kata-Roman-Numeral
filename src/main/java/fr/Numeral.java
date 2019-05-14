package fr;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.repeat;

class Numeral {
    private final int number;
    private final StringBuilder numeral = new StringBuilder();

    Numeral(int number) {
        this.number = number;
    }

    String print(Map<Integer, String> numericToNumeralMap) {
        buildNumeral(numericToNumeralMap);
        return numeral.toString();
    }

    private void buildNumeral(Map<Integer, String> numericToNumeralMap) {
        int remainder = this.number;

        List<Integer> numbers = getReverseSortedKey(numericToNumeralMap);

        for (int number : numbers) {
            remainder = getRemainderAndUpdateNumeralForValue(numericToNumeralMap, remainder, number);
        }
    }

    private List<Integer> getReverseSortedKey(Map<Integer, String> numericToNumeralMap) {
        return numericToNumeralMap.keySet()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private int getRemainderAndUpdateNumeralForValue(Map<Integer, String> numericToNumeralMap, int remainder, int value) {
        int times = remainder / value;

        if (times > 0) {
            this.numeral.append(repeat(numericToNumeralMap.get(value), times));
            remainder -= value * times;
        }

        if (remainder != 0 && remainder % value == value - 1) {
            this.numeral.append(numericToNumeralMap.get(1))
                    .append(numericToNumeralMap.get(value));
            remainder -= value - 1;
        }
        return remainder;
    }
}
