package jib.dao.author;

import jib.model.entities.AuthorEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AuthorSpecification {

    public static Specification<AuthorEntity> filter(final AuthorFilter authorFilter) {
        return new Specification<AuthorEntity>() {
            public Predicate toPredicate(Root<AuthorEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                if (authorFilter != null) {


                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

    }
}
