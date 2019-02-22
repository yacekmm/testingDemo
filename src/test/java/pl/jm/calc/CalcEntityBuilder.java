package pl.jm.calc;

import java.time.Instant;
import java.util.UUID;

final class CalcEntityBuilder {

    private UUID id = UUID.randomUUID();
    private Integer age = 23;
    private Integer result = 46;
    private Instant created = Instant.now();

    private final CalcRepository calcRepository;

    private CalcEntityBuilder(CalcRepository calcRepository) {
        this.calcRepository = calcRepository;
    }

    static CalcEntityBuilder aCalcEntity(CalcRepository calcRepository) {
        return new CalcEntityBuilder(calcRepository);
    }

    CalcEntity build() {
        return new CalcEntity(id, age, result, created);
    }

    CalcEntity inDb(){
        return calcRepository.save(build());
    }

    CalcEntityBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    CalcEntityBuilder withAge(Integer age) {
        this.age = age;
        return this;
    }

    CalcEntityBuilder withResult(Integer result) {
        this.result = result;
        return this;
    }

    CalcEntityBuilder withCreated(Instant created) {
        this.created = created;
        return this;
    }

}
