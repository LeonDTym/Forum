package com.twopythons.forum.model.repository;

import com.twopythons.forum.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
