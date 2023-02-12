package com.apps.centralpurchasing.business;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public abstract class AbstractCrudServiceImpl<T extends Serializable> implements CrudOperations<T> {
    @Override
    public T getOne(Long id) {
        return getRepository().findById(id)
                .orElse(null);
    }

    @Override
    public Page<T> getAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public T create(T t) {
        return getRepository().save(t);
    }

    @Override
    public T update(Long id, T t) {
        return getRepository().save(t);
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    protected abstract JpaRepository<T, Long> getRepository();
}
