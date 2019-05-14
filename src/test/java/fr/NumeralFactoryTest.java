package fr;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class NumeralFactoryTest {

    @Test
    @Parameters({
            "1,I",
            "2,II",
            "3,III",
            "4,IV",
            "5,V",
            "6,VI",
            "7,VII",
            "8,VIII",
            "9,IX",
            "10,X",
            "29,XXIX",
            "80,LXXX",
            "294,CCXCIV",
            "2019,MMXIX",
            "800,DCCC",
            "900,CM"})
    public void convert_numeric_into_numeral(int numeric, String numeralExpected) {
        NumeralFactory numeralFactory = new NumeralFactory();

        String result = numeralFactory.of(numeric);

        assertThat(result).isEqualTo(numeralExpected);
    }

}