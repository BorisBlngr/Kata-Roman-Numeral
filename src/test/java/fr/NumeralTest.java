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
    public void for_the_numbers_1_to_4_I_symbol_in_multiples_is_used(int numeric, String numeralExpcted) {
        Numeral number = new Numeral(numeric);

        String result = number.print();

        assertThat(result).isEqualTo(numeralExpcted);
    }

    @Test
    public void _5_numeral_should_return_V_symbol() {
        Numeral five = new Numeral(5);

        String result = five.print();

        assertThat(result).isEqualTo("V");
    }

    @Test
    @Parameters({"6,VI", "7,VII", "8,VIII", "9,IX"})
    public void for_the_numbers_6_to_9_V_and_I_symbols_in_multiples_are_used(int numeric, String numeralExpected) {
        Numeral number = new Numeral(numeric);

        String result = number.print();

        assertThat(result).isEqualTo(numeralExpected);
    }

    @Test
    @Parameters({"10,X", "20,XX", "30,XXX"})
    public void for_the_numbers_10_to_30_X_symbol_in_multiples_is_used(int numeric, String numeralExpected) {
        Numeral number = new Numeral(numeric);

        String result = number.print();

        assertThat(result).isEqualTo(numeralExpected);
    }

    @Test
    public void _40_numeral_should_return_XL_symbol() {
        Numeral forty = new Numeral(40);

        String result = forty.print();

        assertThat(result).isEqualTo("XL");
    }

    @Test
    public void _90_numeral_should_return_XC_symbol() {
        Numeral forty = new Numeral(90);

        String result = forty.print();

        assertThat(result).isEqualTo("XC");
    }

    @Test
    public void _100_numeral_should_return_C_symbol() {
        Numeral forty = new Numeral(100);

        String result = forty.print();

        assertThat(result).isEqualTo("C");
    }


    @Test
    @Parameters({"200,CC", "300,CCC", "400,CD", "500,D", "600,DC", "700,DCC", "800,DCCC", "900,CM"})
    public void for_the_numbers_200_to__900_C_D_and_M_symbols_are_used(int numeric, String numeralExpected) {
        Numeral number = new Numeral(numeric);

        String result = number.print();

        assertThat(result).isEqualTo(numeralExpected);
    }
}