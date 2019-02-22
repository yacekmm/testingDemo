package pl.jm.calc;

import org.junit.Before;
import org.junit.Test;
import pl.jm.user.UserApi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CalcEntityBuilderUnitTest {

    private CalcRepository calcRepository;
    private CalcEntityBuilder calcEntityBuilder;

    @Before
    public void setUp() {
        calcRepository = new CalcTestRepository();
        calcEntityBuilder = CalcEntityBuilder.aCalcEntity(calcRepository);
    }

    @Test
    public void calcBuilder_storesCalcInDb() {

        //when
        CalcEntity calcEntity = calcEntityBuilder.inDb();

        //then
        assertThat(calcRepository.findById(calcEntity.getId())).isNotEmpty();
    }
}
