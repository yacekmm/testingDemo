package pl.jm.calc;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcValidatorTest {

    CalcValidator calcValidator;

    @Before
    public void setUp() {
        calcValidator = new CalcValidator();
    }

    @Test
    public void ageValidation_returnsValid() {

        assertThat(calcValidator.ageIsValid(18)).isTrue();
        assertThat(calcValidator.ageIsValid(33)).isTrue();
        assertThat(calcValidator.ageIsValid(Integer.MAX_VALUE)).isTrue();
    }

    @Test
    public void ageValidation_returnsNotValid() {

        assertThat(calcValidator.ageIsValid(17)).isFalse();
        assertThat(calcValidator.ageIsValid(0)).isFalse();
        assertThat(calcValidator.ageIsValid(Integer.MIN_VALUE)).isFalse();
    }
}