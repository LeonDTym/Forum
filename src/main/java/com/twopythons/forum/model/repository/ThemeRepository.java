package com.twopythons.forum.model.repository;

import com.twopythons.forum.model.entity.Theme;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    @Query("select t from Theme t where t.author.id = :id")
    List<Theme> getAllByUserId(Long id);

    @Query("select t from Theme t where t.title like CONCAT('%',:title,'%')")
    List<Theme> findByTitle(String title, Pageable pageable);
    @Query("select t from Theme t join t.tags tg where tg.name = :tag")
    List<Theme> findByTag(String tag, Pageable pageable);
}
