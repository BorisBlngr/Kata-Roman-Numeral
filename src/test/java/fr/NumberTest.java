package fr;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class NumberTest {

    @Test
    @Parameters({"1,I", "2,II", "3,III", "4,IIII"})
    public void for_the_numbers_1_to_4_I_symbol_in_multiples_is_used(int numeric, String numeral) {
        Number number = new Number(numeric);

        Assertions.assertThat(number.numeral()).isEqualTo(numeral);
    }
}