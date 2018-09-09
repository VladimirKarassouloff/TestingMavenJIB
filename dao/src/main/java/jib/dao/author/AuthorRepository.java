package jib.dao.author;

import jib.dao.CustomRepository;
import jib.model.entities.AuthorEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends CustomRepository<AuthorEntity, UUID> {
}
