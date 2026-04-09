package com.vittacore.shared.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class BaseCrudResource<T, ID extends Serializable> {

    protected abstract BaseCrudService<T, ID> getService();

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T created = getService().create(entity);
        return ResponseEntity.ok(created);
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T entity) {
        T updated = getService().update(entity);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody T entity) {
        getService().delete(entity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) {
        T entity = getService().findById(id);
        return ResponseEntity.ok(entity);
    }

}