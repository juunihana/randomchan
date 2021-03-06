package org.projects.randomchan.service;

import org.projects.randomchan.model.bean.BoardBean;

import java.util.List;

public interface BoardService {

    BoardBean findById(long id);

    List<BoardBean> findAll();

    BoardBean findByName(String name);

    void save(BoardBean boardBean);

    void delete(BoardBean boardBean);
}
