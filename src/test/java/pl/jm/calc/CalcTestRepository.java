package pl.jm.calc;

import pl.jm.InMemoryRepository;

import java.util.UUID;

class CalcTestRepository
        extends InMemoryRepository<CalcEntity, UUID>
        implements CalcRepository {
}
