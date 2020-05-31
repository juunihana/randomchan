package org.projects.randomchan.service.implementation;

import org.mapstruct.factory.Mappers;
import org.projects.randomchan.mapper.ModelMapper;
import org.projects.randomchan.model.bean.ThreadBean;
import org.projects.randomchan.repository.ThreadRepository;
import org.projects.randomchan.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThreadServiceImpl implements ThreadService {

    private final ThreadRepository threadRepository;

    private final ModelMapper modelMapper = Mappers.getMapper(ModelMapper.class);

    @Autowired
    public ThreadServiceImpl(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    @Transactional
    public ThreadBean findById(long id) {
        return modelMapper.threadEntityToThreadBean(threadRepository.findById(id));
    }

    @Transactional
    public List<ThreadBean> findAll() {
        return threadRepository.findAll().stream()
                .map(modelMapper::threadEntityToThreadBean)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(ThreadBean threadBean) {
        threadRepository.save(modelMapper.threadBeanToThreadEntity(threadBean));
    }

    @Transactional
    public void delete(ThreadBean threadBean) {
        threadRepository.delete(modelMapper.threadBeanToThreadEntity(threadBean));
    }
}
