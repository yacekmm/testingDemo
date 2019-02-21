package pl.jm.calc;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class CalcService {

    private CalcValidator calcValidator;

    int calcRating(int age) {
        if (calcValidator.ageIsValid(age)) {
            return age * 2;
        } else {
            return 0;
        }
    }
}