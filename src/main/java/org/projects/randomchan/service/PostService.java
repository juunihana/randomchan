package org.projects.randomchan.service;

import org.projects.randomchan.model.bean.PostBean;

import java.util.List;

public interface PostService {

    PostBean findById(long id);

    List<PostBean> findAll();

    void save(PostBean postBean);

    void delete(PostBean postBean);
}
