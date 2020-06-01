package org.projects.randomchan.service;

import org.projects.randomchan.model.bean.TagBean;

import java.util.List;

public interface TagService {

    TagBean findById(long id);

    List<TagBean> findAll();

    void save(TagBean tagBean);

    void delete(TagBean tagBean);
}
