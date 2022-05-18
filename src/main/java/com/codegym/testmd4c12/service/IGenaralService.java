package com.codegym.testmd4c12.service;

import java.util.Optional;

public interface IGenaralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
