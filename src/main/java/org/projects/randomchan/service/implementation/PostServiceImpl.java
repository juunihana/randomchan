package org.projects.randomchan.service.implementation;

import org.mapstruct.factory.Mappers;
import org.projects.randomchan.mapper.ModelMapper;
import org.projects.randomchan.model.bean.PostBean;
import org.projects.randomchan.repository.PostRepository;
import org.projects.randomchan.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final ModelMapper modelMapper = Mappers.getMapper(ModelMapper.class);

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public PostBean findById(long id) {
        return modelMapper.postEntityToPostBean(postRepository.findById(id));
    }

    @Transactional
    public List<PostBean> findAll() {
        return postRepository.findAll().stream()
                .map(modelMapper::postEntityToPostBean)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PostBean> findAllByThreadId(long id) {
        return postRepository.findAllByThreadId(id).stream()
                .map(modelMapper::postEntityToPostBean)
                .collect(Collectors.toList());
    }

    @Transactional
    public PostBean save(PostBean postBean) {
        return modelMapper.postEntityToPostBean(postRepository.save(modelMapper.postBeanToPostEntity(postBean)));
    }

    @Transactional
    public void delete(PostBean postBean) {
        postRepository.delete(modelMapper.postBeanToPostEntity(postBean));
    }
}
