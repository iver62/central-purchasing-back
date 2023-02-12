package com.apps.centralpurchasing.business;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface CrudOperations<T extends Serializable> {

    T getOne(final Long id);

    Page<T> getAll(final Pageable pageable);

    T create(final T t);

    T update(final Long id, final T t);

    void delete(final Long id);
}
