package pl.jm.calc;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import pl.jm.TestClockConfig;
import pl.jm.user.UserApi;

import java.time.Clock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CalcApiTest {

    private CalcApi calcApi;
    private UserApi userApi;
    private CalcRepository calcRepository;

    @Before
    public void setUp() {

        userApi = mock(UserApi.class);
        calcRepository = new CalcTestRepository();
        Clock testClock = new TestClockConfig().testClock();

        calcApi = new CalcApi(
                new CalcService(new CalcValidator(), userApi, calcRepository, testClock)
        );

        given(userApi.verifyUser(anyInt())).willReturn(true);
    }

    @Test
    public void calculate_persistsResult() {
        //when
        calcApi.calcRating(27);

        //then
        assertThat(calcRepository.findAll()).hasSize(1);
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

    @Test
    public void calculate_persistsCalcCreationTime() {
        //when
        calcApi.calcRating(17);

        //then
        assertThat(calcRepository.findByCreated(TestClockConfig.TEST_TIME)).hasSize(1);
    }

}
