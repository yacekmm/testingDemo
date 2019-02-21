package pl.jm.calc;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.mockito.Mockito.mock;

public class CalcServiceTest {

    private CalcService calcService;

    @Before
    public void setUp() {
        calcService = new CalcService();
    }

    @Test
    public void calculate_returnsRating() {
        //when
        int rating = calcService.calcRating(23);

        //then
        assertThat(rating).isEqualTo(46);
    }

}
