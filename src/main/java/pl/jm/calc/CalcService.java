package pl.jm.calc;

import lombok.AllArgsConstructor;
import pl.jm.user.UserApi;

@AllArgsConstructor
class CalcService {

    private CalcValidator calcValidator;
    private UserApi userApi;

    int calcRating(int age) {

        int result = performCalc(age);

        return result;
    }

    private int performCalc(int age) {
        if (calcValidator.ageIsValid(age)
                && userApi.verifyUser(age)) {
            return age * 2;
        } else {
            return 0;
        }
    }
}