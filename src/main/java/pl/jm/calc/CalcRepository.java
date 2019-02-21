package pl.jm.calc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CalcRepository extends CrudRepository<CalcEntity, UUID> {

//    Collection<CalcEntity> findRejectedCalcs(UUID userId);

}
