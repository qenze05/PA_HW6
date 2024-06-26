package org.example;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnit5Tests {

    @Test
    public void division() {
        int fst = 90;
        int snd = 10;
        assertThat(snd).isNotEqualTo(0);
        assertEquals(90 / 10, 9, "90 / 10 should be equal to 9");
    }

    @Test
    public void divisionToZero() {
        int fst = 90;
        int snd = 10;
        snd = 0;
        assertThat(snd).isNotEqualTo(0);
        assertEquals(90 / 10, 9, "90 / 10 should be equal to 9");
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 1",
            "0, 0, 0",
            "0, 1, 0",
            "20, 2, 10"
    })
    void division(int a, int b, int expectedResult) {
        Assumptions.assumeTrue(b != 0);
        assertEquals(a / b, expectedResult);
    }


}
