package pl.jm.calc;

import lombok.AllArgsConstructor;
import pl.jm.infrastructure.ModuleApi;

@AllArgsConstructor
@ModuleApi
public class CalcApi {

    private final CalcService calcService;

    public int calcRating(int age) {

        int result = performCalc(age);

        return result;
    }

    private int performCalc(int age) {
        return calcService.calcRating(age);
    }
}