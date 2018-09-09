package jib.dao.video;

import jib.model.entities.VideoEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class VideoSpecification {

    public static Specification<VideoEntity> filter(final VideoFilter videoFilter) {
        return new Specification<VideoEntity>() {
            public Predicate toPredicate(Root<VideoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                if (videoFilter != null) {


                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

    }
}
