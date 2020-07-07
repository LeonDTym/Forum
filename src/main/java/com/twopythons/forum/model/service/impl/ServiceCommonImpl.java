package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.exceptions.ItemAlreadyExistsException;
import com.twopythons.forum.model.entity.AbstractEntity;
import com.twopythons.forum.model.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceCommonImpl<E extends AbstractEntity, R extends JpaRepository<E, Long>> implements Service<E> {

    final protected R repository;

    @Autowired
    public ServiceCommonImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void create(E item) throws ItemAlreadyExistsException {
        Optional<E> foundItem = getById(item.getId());
        if (foundItem.isPresent()) {
            throw  new ItemAlreadyExistsException("Item with id = " + item.getId() + " already exists!");
        }
        else {
            repository.save(item);
        }
    }

    @Override
    public void deleteById(Long id) {
        getById(id).ifPresent(item -> repository.delete(item));
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
