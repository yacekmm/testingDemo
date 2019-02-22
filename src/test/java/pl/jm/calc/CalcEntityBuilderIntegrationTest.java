package pl.jm.calc;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT, properties = "server.port=9090")
public class CalcEntityBuilderIntegrationTest {

    @Autowired
    private CalcRepository calcRepository;

    private CalcEntityBuilder calcEntityBuilder;

    @Before
    public void setUp() {
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
