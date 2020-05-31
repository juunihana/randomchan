package org.projects.randomchan.repository;

import org.projects.randomchan.model.entity.ThreadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreadRepository extends JpaRepository<ThreadEntity, Long> {

    ThreadEntity findById(long id);
    List<ThreadEntity> findAll();
}
