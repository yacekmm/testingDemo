package pl.jm.calc;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.mockito.Mockito.mock;

public class CalcServiceTest {

    private CalcService calcService;
    private CalcValidator calcValidator;

    @Before
    public void setUp() {
        calcValidator = mock(CalcValidator.class);

        calcService = new CalcService(calcValidator);
    }

    @Test
    public void calculate_returnsRating_forAdult() {
        //given
        given(calcValidator.ageIsValid(23)).willReturn(true);

        //when
        int rating = calcService.calcRating(23);

        //then
        verify(calcValidator).ageIsValid(23);
        assertThat(rating).isEqualTo(46);
    }

    @Test
    public void calculate_returnsRating_forNotAdult() {
        //given
        given(calcValidator.ageIsValid(3)).willReturn(false);

        //when
        int rating = calcService.calcRating(3);

        //then
        assertThat(rating).isEqualTo(0);
    }

}
