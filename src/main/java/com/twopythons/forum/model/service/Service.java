package com.twopythons.forum.model.service;

import com.twopythons.forum.exceptions.ItemAlreadyExistsException;
import com.twopythons.forum.model.entity.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface Service<E extends AbstractEntity> {
    void create(E item) throws ItemAlreadyExistsException;
    Optional<E> getById(Long id);
    List<E> getAll();
}
