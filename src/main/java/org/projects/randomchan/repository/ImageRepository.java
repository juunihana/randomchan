package org.projects.randomchan.repository;

import org.projects.randomchan.model.entity.BoardEntity;
import org.projects.randomchan.model.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

    ImageEntity findById(long id);

    List<ImageEntity> findAll();
}
