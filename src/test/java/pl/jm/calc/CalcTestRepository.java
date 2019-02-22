package pl.jm.calc;

import pl.jm.InMemoryRepository;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

class CalcTestRepository
        extends InMemoryRepository<CalcEntity, UUID>
        implements CalcRepository {

    @Override
    public Collection<CalcEntity> findByCreated(Instant instant) {

        return database.values().stream()
                .filter(e -> e.getCreated().equals(instant))
                .collect(Collectors.toList());
    }
}
