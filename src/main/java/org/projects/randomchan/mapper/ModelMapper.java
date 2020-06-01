package org.projects.randomchan.mapper;

import org.mapstruct.Mapper;
import org.projects.randomchan.model.bean.*;
import org.projects.randomchan.model.entity.*;

@Mapper
public interface ModelMapper {

    ThreadBean threadEntityToThreadBean(ThreadEntity threadEntity);
    ThreadEntity threadBeanToThreadEntity(ThreadBean threadBean);

    PostBean postEntityToPostBean(PostEntity postEntity);
    PostEntity postBeanToPostEntity(PostBean postBean);

    BoardBean boardEntityToBoardBean(BoardEntity boardEntity);
    BoardEntity boardBeanToBoardEntity(BoardBean boardBean);

    ImageBean imageEntityToImageBean(ImageEntity imageEntity);
    ImageEntity imageBeanToImageEntity(ImageBean imageBean);

    TagBean tagEntityToTagBean(TagEntity tagEntity);
    TagEntity tagBeanToTagEntity(TagBean tagBean);
}
