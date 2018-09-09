package jib.service;

import jib.dao.CustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IService<ENTITY, FILTER> {

    default void flush() {
        getRepository().flush();
    }

    default ENTITY save(ENTITY e) {
        return getRepository().save(e);
    }

    default Page<ENTITY> get(PageRequest pageRequest) {
        return getRepository().findAll(pageRequest);
    }

    default Page<ENTITY> get(PageRequest pageRequest, FILTER filter) {
        return getRepository().findAll(pageRequest);
    }

    default List<ENTITY> getAll() {
        return getRepository().findAll();
    }

    default List<ENTITY> getAll(FILTER filter) {
        return getRepository().findAll();
    }

    default void deleteAll(FILTER filter) {
        List<ENTITY> entitiesToDelete = getAll(filter);
        entitiesToDelete.forEach(e -> getRepository().delete(e));
    }

    default ENTITY getOneOrNull(FILTER filter) {
        Page<ENTITY> entities = get(new PageRequest(0, 1), filter);
        if (entities.hasContent() && !entities.getContent().isEmpty()) {
            return entities.getContent().get(0);
        } else {
            return null;
        }
    }

    CustomRepository<ENTITY, ?> getRepository();

    Specification<ENTITY> specificate(FILTER filter);
}
