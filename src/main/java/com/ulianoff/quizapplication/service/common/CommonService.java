package com.ulianoff.quizapplication.service.common;

import java.util.List;

public interface CommonService<T> {

    T createGameSession(T entity);

    T getById(String id);

    List<T> getAll();

    boolean delete(T entity);

    boolean deleteById(String id);
}
