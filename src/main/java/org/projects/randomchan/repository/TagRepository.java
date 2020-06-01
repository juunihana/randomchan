package org.projects.randomchan.repository;

import org.projects.randomchan.model.entity.BoardEntity;
import org.projects.randomchan.model.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

    TagEntity findById(long id);

    List<TagEntity> findAll();
}
