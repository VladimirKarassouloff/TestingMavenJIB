package jib.model.entities;

import jib.model.listener.IdGenerator;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(IdGenerator.class)
@Data
public class AbstractEntity {

    private static final String COLUMN_NAME_ID = "ID";

    @Id
    @Column(name = COLUMN_NAME_ID)
    private UUID id;

}
