package jib.service.author;

import jib.dao.CustomRepository;
import jib.dao.author.AuthorFilter;
import jib.dao.author.AuthorRepository;
import jib.dao.author.AuthorSpecification;
import jib.model.entities.AuthorEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements IAuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Specification<AuthorEntity> specificate(AuthorFilter authorFilter) {
        return AuthorSpecification.filter(authorFilter);
    }

    @Override
    public CustomRepository<AuthorEntity, ?> getRepository() {
        return authorRepository;
    }
}
