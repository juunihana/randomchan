package org.projects.randomchan.repository;

import org.projects.randomchan.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    BoardEntity findById(long id);

    List<BoardEntity> findAll();

    BoardEntity findByName(String name);
}
