package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.AbstractEntity;
import com.twopythons.forum.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceCommonImpl<E extends AbstractEntity, R extends JpaRepository<E, Long>> implements Service<E> {

    final protected R repository;

    public ServiceCommonImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void create(E item) {
            repository.save(item);

    }

    @Override
    public Optional<E> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<E> getAll() {
        return repository.findAll();
    }
}
