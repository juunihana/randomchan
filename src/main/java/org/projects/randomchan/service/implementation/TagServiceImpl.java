package org.projects.randomchan.service.implementation;

import org.mapstruct.factory.Mappers;
import org.projects.randomchan.mapper.ModelMapper;
import org.projects.randomchan.model.bean.TagBean;
import org.projects.randomchan.repository.TagRepository;
import org.projects.randomchan.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    private final ModelMapper modelMapper = Mappers.getMapper(ModelMapper.class);

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Transactional
    public TagBean findById(long id) {
        return modelMapper.tagEntityToTagBean(tagRepository.findById(id));
    }

    @Transactional
    public List<TagBean> findAll() {
        return tagRepository.findAll().stream()
                .map(modelMapper::tagEntityToTagBean)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(TagBean tagBean) {
        tagRepository.save(modelMapper.tagBeanToTagEntity(tagBean));
    }

    @Transactional
    public void delete(TagBean tagBean) {
        tagRepository.delete(modelMapper.tagBeanToTagEntity(tagBean));
    }
}
