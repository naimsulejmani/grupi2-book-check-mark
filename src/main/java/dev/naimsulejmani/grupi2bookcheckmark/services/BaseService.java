package dev.naimsulejmani.grupi2bookcheckmark.services;

import java.util.List;

public interface BaseService<T, Tid> {
    List<T> findAll();

    T findById(Tid id);

    T add(T model);

    T modify(Tid id, T model);

    void deleteById(Tid id);
}
