package com.vittacore.shared.base;

import java.io.Serializable;
import java.util.List;

public interface BaseCrudService<T, ID extends Serializable> {

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    T findById(ID id);

    List<T> findAll();

    void validate(T entity);

    void validateDelete(T entity);
}