package pl.jm.calc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@Repository
interface CalcRepository extends CrudRepository<CalcEntity, UUID> {

    Collection<CalcEntity> findByCreated(Instant instant);

}
