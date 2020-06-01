package org.projects.randomchan.service.implementation;

import org.mapstruct.factory.Mappers;
import org.projects.randomchan.mapper.ModelMapper;
import org.projects.randomchan.model.bean.ImageBean;
import org.projects.randomchan.repository.ImageRepository;
import org.projects.randomchan.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    private final ModelMapper modelMapper = Mappers.getMapper(ModelMapper.class);

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public ImageBean findById(long id) {
        return modelMapper.imageEntityToImageBean(imageRepository.findById(id));
    }

    @Transactional
    public List<ImageBean> findAll() {
        return imageRepository.findAll().stream()
                .map(modelMapper::imageEntityToImageBean)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(ImageBean imageBean) {
        imageRepository.save(modelMapper.imageBeanToImageEntity(imageBean));
    }

    @Transactional
    public void delete(ImageBean imageBean) {
        imageRepository.delete(modelMapper.imageBeanToImageEntity(imageBean));
    }
}
