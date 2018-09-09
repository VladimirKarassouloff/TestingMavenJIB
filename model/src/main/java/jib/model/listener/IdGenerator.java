package jib.model.listener;

import jib.model.entities.AbstractEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class IdGenerator {

    @PrePersist
    public void userPrePersist(AbstractEntity entity) {
        entity.setId(UUID.randomUUID());
    }

}
