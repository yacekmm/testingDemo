package pl.jm.calc;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class CalcService {

    int calcRating(int age) {
        return age * 2;
    }
}