package by.paramonov.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder(toBuilder = true, setterPrefix = "with")
public abstract class BaseEntity {

    @Id
    @Column(name = "id")
    private long id;
}
