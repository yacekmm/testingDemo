package pl.jm.calc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "calculations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
class CalcEntity {

    @Id
    @Column(updatable = false, nullable = false, name = "id")
    private UUID id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "result")
    private Integer result;
}
