package fr;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class NumberTest {
    @Test
    public void for_the_numbers_1_to_4_I_symbol_in_multiples_is_used() {
        Number number = new Number(1);

        Assertions.assertThat(number.numeral()).isEqualTo("I");
    }
}