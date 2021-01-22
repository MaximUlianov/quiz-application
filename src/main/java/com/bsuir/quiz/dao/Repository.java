package com.bsuir.quiz.dao;

import java.util.List;

public interface Repository<T> {
    T getById(long id);
    List<T> getAll();
    T add(T entity);
    T update(T entity);
    void delete(T entity);
    void deleteById(long entityId);
}
