package com.vittacore.shared.Abstract;

import com.vittacore.shared.base.BaseCrudRepository;
import com.vittacore.shared.base.BaseCrudService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional(rollbackFor = Throwable.class)
public abstract class AbstractCrudService<T, ID extends Serializable> implements BaseCrudService<T, ID> {

    protected abstract BaseCrudRepository<T, ID> getRepository();

    @Override
    public T create(T entity) {
        validate(entity);
        beforeCreate(entity);

        T saved = getRepository().save(entity);

        afterCreate(saved);
        return saved;
    }

    @Override
    public T update(T entity) {
        validate(entity);
        beforeUpdate(entity);

        T updated = getRepository().update(entity);

        afterUpdate(updated);
        return updated;
    }

    @Override
    public void delete(T entity) {
        validateDelete(entity);
        beforeDelete(entity);

        getRepository().delete(entity);

        afterDelete(entity);
    }

    @Override
    public T findById(ID id) {
        return getRepository().findById(id);
    }

    protected void beforeCreate(T entity) {}
    protected void afterCreate(T entity) {}

    protected void beforeUpdate(T entity) {}
    protected void afterUpdate(T entity) {}

    protected void beforeDelete(T entity) {}
    protected void afterDelete(T entity) {}

    @Override
    public void validate(T entity) {}

    @Override
    public void validateDelete(T entity) {}
}
