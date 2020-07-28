package com.twopythons.forum.model.repository;

import com.twopythons.forum.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findTagByName(String name);

}
