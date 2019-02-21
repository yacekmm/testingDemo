package pl.jm.calc;

import java.util.UUID;

public final class CalcEntityBuilder {

    private UUID id = UUID.randomUUID();
    private Integer age = 23;
    private Integer result = 46;

    private final CalcRepository calcRepository;

    private CalcEntityBuilder(CalcRepository calcRepository) {
        this.calcRepository = calcRepository;
    }

    public static CalcEntityBuilder aCalcEntity(CalcRepository calcRepository) {
        return new CalcEntityBuilder(calcRepository);
    }

    public CalcEntity build() {
        return new CalcEntity(id, age, result);
    }

    public CalcEntity inDb(){
        return calcRepository.save(build());
    }

    public CalcEntityBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public CalcEntityBuilder withAge(Integer age) {
        this.age = age;
        return this;
    }

    public CalcEntityBuilder withResult(Integer result) {
        this.result = result;
        return this;
    }

}
