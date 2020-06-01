package org.projects.randomchan.service;

import org.projects.randomchan.model.bean.ImageBean;

import java.util.List;

public interface ImageService {

    ImageBean findById(long id);

    List<ImageBean> findAll();

    void save(ImageBean imageBean);

    void delete(ImageBean imageBean);
}
