package fr;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class NumberTest {

    @Test
    @Parameters({"1,I", "2,II", "3,III", "4,IIII"})
    public void for_the_numbers_1_to_4_I_symbol_in_multiples_is_used(int numeric, String numeral) {
        Number number = new Number(numeric);

        assertThat(number.numeral()).isEqualTo(numeral);
    }

    @Test
    public void _5_numeral_should_return_V_symbol() {
        Number five = new Number(5);

        assertThat(five.numeral()).isEqualTo("V");
    }
}