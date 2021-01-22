package com.bsuir.quiz.converter

interface ModelConverter<T, S> {
     T convertFromDto(S dto);
     S convertToDto(T entity);
}
