package com.twopythons.forum.model.repository;

import com.twopythons.forum.model.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    @Query("select t from Theme t where t.user.id = :id")
    List<Theme> getAllByUserId(Long id);

}
