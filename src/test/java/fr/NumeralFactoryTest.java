package fr;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class NumeralFactoryTest {

    @Test
    @Parameters({"1,I", "2,II", "3,III", "4,IV"})
    public void for_the_numerals_1_to_4_I_symbol_in_multiples_is_used(int numeric, String numeralExpcted) {
        NumeralFactory numeralFactory = new NumeralFactory();

        String result = numeralFactory.of(numeric);

        assertThat(result).isEqualTo(numeralExpcted);
    }

    @Test
    public void _5_numeral_should_return_V_symbol() {
        NumeralFactory five = new NumeralFactory();

        String result = five.of(5);

        assertThat(result).isEqualTo("V");
    }

    @Test
    @Parameters({"6,VI", "7,VII", "8,VIII", "9,IX"})
    public void for_the_numerals_6_to_9_V_and_I_symbols_in_multiples_are_used(int numeric, String numeralExpected) {
        NumeralFactory numeralFactory = new NumeralFactory();

        String result = numeralFactory.of(numeric);

        assertThat(result).isEqualTo(numeralExpected);
    }

    @Test
    @Parameters({"10,X", "20,XX", "30,XXX"})
    public void for_the_numerals_10_to_30_X_symbol_in_multiples_is_used(int numeric, String numeralExpected) {
        NumeralFactory numeralFactory = new NumeralFactory();

        String result = numeralFactory.of(numeric);

        assertThat(result).isEqualTo(numeralExpected);
    }

    @Test
    public void _40_numeral_should_return_XL_symbol() {
        NumeralFactory forty = new NumeralFactory();

        String result = forty.of(40);

        assertThat(result).isEqualTo("XL");
    }

    @Test
    public void _90_numeral_should_return_XC_symbol() {
        NumeralFactory forty = new NumeralFactory();

        String result = forty.of(90);

        assertThat(result).isEqualTo("XC");
    }

    @Test
    public void _100_numeral_should_return_C_symbol() {
        NumeralFactory forty = new NumeralFactory();

        String result = forty.of(100);

        assertThat(result).isEqualTo("C");
    }


    @Test
    @Parameters({"200,CC", "300,CCC", "400,CD", "500,D", "600,DC", "700,DCC", "800,DCCC", "900,CM"})
    public void for_the_numerals_200_to__900_C_D_and_M_symbols_are_used(int numeric, String numeralExpected) {
        NumeralFactory numeralFactory = new NumeralFactory();

        String result = numeralFactory.of(numeric);

        assertThat(result).isEqualTo(numeralExpected);
    }

    @Test
    @Parameters({"4,IV", "9,IX", "29,XXIX", "80,LXXX", "294,CCXCIV", "2019,MMXIX", "800,DCCC", "900,CM"})
    public void acceptance(int numeric, String numeralExpected) {
        NumeralFactory numeralFactory = new NumeralFactory();

        String result = numeralFactory.of(numeric);

        assertThat(result).isEqualTo(numeralExpected);
    }

}