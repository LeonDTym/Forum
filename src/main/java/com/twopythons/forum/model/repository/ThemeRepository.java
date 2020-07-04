package com.twopythons.forum.model.repository;

import com.twopythons.forum.model.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
