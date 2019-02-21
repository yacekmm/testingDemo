package pl.jm.calc;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcServiceTest {

    private CalcService calcService;
    private CalcValidator calcValidator;

    @Before
    public void setUp() {
        calcValidator = new CalcValidator();
        calcService = new CalcService(calcValidator);
    }

    @Test
    public void calculate_returnsRating_forAdult() {
        //when
        int rating = calcService.calcRating(23);

        //then
        assertThat(rating).isEqualTo(46);
    }

    @Test
    public void calculate_returnsRating_forNotAdult() {
        //when
        int rating = calcService.calcRating(17);

        //then
        assertThat(rating).isEqualTo(0);
    }

}
