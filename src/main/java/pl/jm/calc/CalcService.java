package pl.jm.calc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jm.user.UserApi;

import java.util.UUID;

@Service
@AllArgsConstructor
class CalcService {

    private CalcValidator calcValidator;
    private UserApi userApi;
    private CalcRepository calcRepository;

    int calcRating(int age) {

        int result = performCalculation(age);
        calcRepository.save(new CalcEntity(UUID.randomUUID(), age, result));
        return result;
    }

    private int performCalculation(int age) {
        if (calcValidator.ageIsValid(age)
                && userApi.verifyUser(age)) {
            return age * 2;
        } else {
            return 0;
        }
    }
}