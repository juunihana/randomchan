package org.projects.randomchan.mapper;

import org.mapstruct.Mapper;
import org.projects.randomchan.model.bean.PostBean;
import org.projects.randomchan.model.bean.ThreadBean;
import org.projects.randomchan.model.entity.PostEntity;
import org.projects.randomchan.model.entity.ThreadEntity;

@Mapper
public interface ModelMapper {

    ThreadBean threadEntityToThreadBean(ThreadEntity threadEntity);
    ThreadEntity threadBeanToThreadEntity(ThreadBean threadBean);

    PostBean postEntityToPostBean(PostEntity postEntity);
    PostEntity postBeanToPostEntity(PostBean postBean);
}
