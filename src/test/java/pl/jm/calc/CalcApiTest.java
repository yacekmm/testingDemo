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
    private CalcRepository calcRepository;
    private UserApi userApi;
    private CalcEntityBuilder calcEntityBuilder;

    @Before
    public void setUp() {
        calcRepository = new CalcTestRepository();
        userApi = mock(UserApi.class);

        calcApi = new CalcApi(
                new CalcService(new CalcValidator(), userApi, calcRepository)
        );

        calcEntityBuilder = CalcEntityBuilder.aCalcEntity(calcRepository);

        given(userApi.verifyUser(anyInt())).willReturn(true);
    }

    @Test
    public void calculate_returnsRating_forAdult() {
        //when
        int result = calcApi.calculateRating(22);

        //then
        assertThat(result).isEqualTo(44);
    }

    @Test
    public void calculate_savesRating() {
        //when
        int result = calcApi.calculateRating(22);

        //then
        assertThat(result).isEqualTo(44);
        assertThat(calcRepository.findAll()).hasSize(1);
    }

    @Test
    public void calculate_returnsZero_forNotAdult() {
        //when
        int result = calcApi.calculateRating(2);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void calculate_returnsZero_forNotPermittedAdultUser() {
        //given
        given(userApi.verifyUser(anyInt())).willReturn(false);

        //when
        int result = calcApi.calculateRating(23);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void demo_storesCalcInDb(){
        //when
        CalcEntity calcEntity = calcEntityBuilder.inDb();

        //then
        assertThat(calcRepository.findById(calcEntity.getId())).isNotEmpty();
    }
}
