package com.vittacore.shared.base;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.*;

public abstract class BaseQueryBuilder<F, T> {

    @PersistenceContext
    protected EntityManager em;

    private final Class<T> entityClass;
    private final String alias;

    private final List<String> whereClauses = new ArrayList<>();
    private final Map<String, Object> params = new HashMap<>();
    private final List<String> orderBy = new ArrayList<>();

    protected BaseQueryBuilder(Class<T> entityClass, String alias) {
        this.entityClass = entityClass;
        this.alias = alias;
    }

    public abstract void build(F filter);

    protected void andEquals(String field, Object value) {
        if (value != null) {
            String param = generateParam(field);
            whereClauses.add(alias + "." + field + " = :" + param);
            params.put(param, value);
        }
    }

    protected void andLike(String field, String value) {
        if (value != null && !value.isBlank()) {
            String param = generateParam(field);
            whereClauses.add("LOWER(" + alias + "." + field + ") LIKE LOWER(:" + param + ")");
            params.put(param, "%" + value + "%");
        }
    }

    protected void andIn(String field, Collection<?> values) {
        if (values != null && !values.isEmpty()) {
            String param = generateParam(field);
            whereClauses.add(alias + "." + field + " IN (:" + param + ")");
            params.put(param, values);
        }
    }

    protected void andBetween(String field, Object start, Object end) {
        if (start != null && end != null) {
            String paramStart = generateParam(field + "_start");
            String paramEnd = generateParam(field + "_end");

            whereClauses.add(alias + "." + field + " BETWEEN :" + paramStart + " AND :" + paramEnd);

            params.put(paramStart, start);
            params.put(paramEnd, end);
        }
    }

    protected void andGreaterOrEquals(String field, Object value) {
        if (value != null) {
            String param = generateParam(field);
            whereClauses.add(alias + "." + field + " >= :" + param);
            params.put(param, value);
        }
    }

    protected void andLessOrEquals(String field, Object value) {
        if (value != null) {
            String param = generateParam(field);
            whereClauses.add(alias + "." + field + " <= :" + param);
            params.put(param, value);
        }
    }

    protected void orderByAsc(String field) {
        orderBy.add(alias + "." + field + " ASC");
    }

    protected void orderByDesc(String field) {
        orderBy.add(alias + "." + field + " DESC");
    }

    public List<T> list(int offset, int limit) {
        String jpql = buildQuery();

        TypedQuery<T> query = em.createQuery(jpql, entityClass);

        params.forEach(query::setParameter);

        if (offset >= 0) query.setFirstResult(offset);
        if (limit > 0) query.setMaxResults(limit);

        return query.getResultList();
    }

    public Long count() {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT COUNT(").append(alias).append(")").append(" FROM ").append(entityClass.getSimpleName()).append(" ").append(alias);

        if (!whereClauses.isEmpty()) {
            jpql.append(" WHERE ").append(String.join(" AND ", whereClauses));
        }

        TypedQuery<Long> query = em.createQuery(jpql.toString(), Long.class);
        params.forEach(query::setParameter);

        return query.getSingleResult();
    }

    private String buildQuery() {
        StringBuilder jpql = new StringBuilder();

        jpql.append("SELECT ").append(alias).append(" FROM ").append(entityClass.getSimpleName()).append(" ").append(alias);

        if (!whereClauses.isEmpty()) {
            jpql.append(" WHERE ")
                    .append(String.join(" AND ", whereClauses));
        }

        if (!orderBy.isEmpty()) {
            jpql.append(" ORDER BY ")
                    .append(String.join(", ", orderBy));
        }

        return jpql.toString();
    }

    private String generateParam(String field) {
        return field.replace(".", "_") + "_" + params.size();
    }
}