package com.ulianoff.quizapplication.service;

import java.util.List;

public interface CommonService<T> {

    T add(T entity);

    T getById(String id);

    List<T> getAll();

    boolean delete(T entity);

    boolean deleteById(String id);
}
