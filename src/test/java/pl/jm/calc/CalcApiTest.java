package pl.jm.calc;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcApiTest {

    private CalcApi calcApi;

    @Before
    public void setUp() {
        calcApi = new CalcApi(
                new CalcService(new CalcValidator())
        );
    }

    @Test
    public void calculate_returnsRating_forAdult() {
        //when
        int rating = calcApi.calcRating(23);

        //then
        assertThat(rating).isEqualTo(46);
    }

    @Test
    public void calculate_returnsRating_forNotAdult() {
        //when
        int rating = calcApi.calcRating(17);

        //then
        assertThat(rating).isEqualTo(0);
    }

}
