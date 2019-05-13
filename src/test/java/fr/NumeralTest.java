package fr;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class NumeralTest {

    @Test
    @Parameters({"1,I", "2,II", "3,III", "4,IV"})
    public void for_the_numbers_1_to_4_I_symbol_in_multiples_is_used(int numeric, String numeral) {
        Numeral number = new Numeral(numeric);

        assertThat(number.print()).isEqualTo(numeral);
    }

    @Test
    public void _5_numeral_should_return_V_symbol() {
        Numeral five = new Numeral(5);

        assertThat(five.print()).isEqualTo("V");
    }

    @Test
    @Parameters({"6,VI", "7,VII", "8,VIII", "9,IX"})
    public void for_the_numbers_6_to_9_V_and_I_symbols_in_multiples_are_used(int numeric, String numeral) {
        Numeral number = new Numeral(numeric);

        assertThat(number.print()).isEqualTo(numeral);
    }

    @Test
    @Parameters({"10,X", "20,XX", "30,XXX"})
    public void for_the_numbers_10_to_30_X_symbol_in_multiples_is_used(int numeric, String numeral) {
        Numeral number = new Numeral(numeric);

        assertThat(number.print()).isEqualTo(numeral);
    }
}