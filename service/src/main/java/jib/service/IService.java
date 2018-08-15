package jib.service;

import jib.dao.CustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IService<ENTITY, FILTER> {

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

    CustomRepository<ENTITY, ?> getRepository();

    Specification<ENTITY> specificate(FILTER filter);
}
