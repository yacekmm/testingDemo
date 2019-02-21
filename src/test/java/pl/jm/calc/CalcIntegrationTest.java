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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT, properties = "server.port=9090")
public class CalcIntegrationTest {

    @Autowired
    private CalcRepository calcRepository;

    @Before
    public void setUp() {
        RestAssured.port = 9090;
        calcRepository.deleteAll();
    }

    @Test
    public void calculate_returnsRating_forAdult() {
        //when

        //then
    }

}
