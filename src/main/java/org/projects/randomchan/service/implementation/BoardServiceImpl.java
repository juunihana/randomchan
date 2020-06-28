package org.projects.randomchan.service.implementation;

import org.mapstruct.factory.Mappers;
import org.projects.randomchan.mapper.ModelMapper;
import org.projects.randomchan.model.bean.BoardBean;
import org.projects.randomchan.repository.BoardRepository;
import org.projects.randomchan.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final ModelMapper modelMapper = Mappers.getMapper(ModelMapper.class);

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public BoardBean findById(long id) {
        return modelMapper.boardEntityToBoardBean(boardRepository.findById(id));
    }

    @Transactional
    public List<BoardBean> findAll() {
        return boardRepository.findAll().stream()
                .map(modelMapper::boardEntityToBoardBean)
                .collect(Collectors.toList());
    }

    @Transactional
    public BoardBean findByName(String name) {
        return modelMapper.boardEntityToBoardBean(boardRepository.findByName(name));
    }

    @Transactional
    public void save(BoardBean boardBean) {
        boardRepository.save(modelMapper.boardBeanToBoardEntity(boardBean));
    }

    @Transactional
    public void delete(BoardBean boardBean) {
        boardRepository.delete(modelMapper.boardBeanToBoardEntity(boardBean));
    }
}
