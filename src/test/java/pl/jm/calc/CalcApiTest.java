package pl.jm.calc;

import org.junit.Before;
import org.junit.Test;
import pl.jm.user.UserApi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CalcApiTest {

    private CalcApi calcApi;
    private UserApi userApi;

    @Before
    public void setUp() {
        userApi = mock(UserApi.class);
        calcApi = new CalcApi(
                new CalcService(new CalcValidator(), userApi)
        );

        given(userApi.verifyUser(anyInt())).willReturn(true);
    }

    @Test
    public void calculate_returnsRating_forAdultNotAllowedByUserApi() {
        //given
        given(userApi.verifyUser(anyInt())).willReturn(false);

        //when
        int rating = calcApi.calcRating(27);

        //then
        assertThat(rating).isEqualTo(0);
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