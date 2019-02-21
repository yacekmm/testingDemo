package pl.jm.calc;

import lombok.AllArgsConstructor;
import pl.jm.infrastructure.ModuleApi;

@ModuleApi
@AllArgsConstructor
public class CalcApi {

    private final CalcService calcService;

    public int calculateRating(int age) {
        return calcService.calculateRating(age);
    }
}
