package org.projects.randomchan.service;

import org.projects.randomchan.model.bean.ThreadBean;

import java.util.List;

public interface ThreadService {

    ThreadBean findById(long id);

    List<ThreadBean> findAll();

    void save(ThreadBean threadBean);

    void delete(ThreadBean threadBean);
}
