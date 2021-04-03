package com.ulianoff.quizapplication.service;

import java.util.List;

public interface CommonService<T> {
    T addEntity(T entity);

    T getEntityById(Long id);

    List<T> getAllEntities();

    boolean deleteEntity(T entity);

    boolean deleteEntityById(Long id);
}
