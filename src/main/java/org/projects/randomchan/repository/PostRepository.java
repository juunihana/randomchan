package org.projects.randomchan.repository;

import org.projects.randomchan.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    PostEntity findById(long id);

    List<PostEntity> findAll();
}
