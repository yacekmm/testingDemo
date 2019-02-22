package pl.jm.calc;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class CalcController {

    private CalcApi calcApi;

    @PostMapping("/calc/{age}")
    public ResponseEntity<Map<String, Integer>> calculateRating(
            @PathVariable("age") int age) {

        Map<String, Integer> result = Map.of("result", null);
        return ResponseEntity.ok(result);
    }
}
