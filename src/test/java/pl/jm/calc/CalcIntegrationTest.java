package pl.jm.calc;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static pl.jm.calc.CalcEntityBuilder.aCalcEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT, properties = "server.port=9090")
public class CalcIntegrationTest {

    @Autowired
    private CalcRepository calcRepository;

    private CalcEntityBuilder calcEntityBuilder;

    @Before
    public void setUp() {
        calcEntityBuilder = aCalcEntity(calcRepository);
        calcRepository.deleteAll();
    }

    @Test
    public void calculate_returnsRating_forAdult() {
        //when
        Response response = RestAssured.post("http://localhost:9090/calc/22");

        //then
        assertThat(response.statusCode()).isEqualTo(SC_OK);
        assertThat(response.jsonPath().getInt("result")).isEqualTo(44);
        assertThat(calcRepository.findAll()).hasSize(1);
    }

    @Test
    public void demo_storesCalcInDb(){
        //when
        CalcEntity calcEntity = calcEntityBuilder.inDb();

        //then
        assertThat(calcRepository.findById(calcEntity.getId())).isNotEmpty();
    }

}
