package com.sn.dtai.admin.service.impl;

import com.sn.dtai.admin.domain.Postes;
import com.sn.dtai.admin.repository.PostesRepository;
import com.sn.dtai.admin.service.PostesService;
import com.sn.dtai.admin.service.dto.PostesDTO;
import com.sn.dtai.admin.service.mapper.PostesMapper;
import java.util.Optional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Postes}.
 */
@Service
@Transactional
public class PostesServiceImpl implements PostesService {

    private final Logger log = LoggerFactory.getLogger(PostesServiceImpl.class);

    private final PostesRepository postesRepository;

    private final PostesMapper postesMapper;

    public PostesServiceImpl(PostesRepository postesRepository, PostesMapper postesMapper) {
        this.postesRepository = postesRepository;
        this.postesMapper = postesMapper;
    }

    @Override
    public PostesDTO save(PostesDTO postesDTO) {
        log.debug("Request to save Postes : {}", postesDTO);
        Postes postes = postesMapper.toEntity(postesDTO);
        postes = postesRepository.save(postes);
        return postesMapper.toDto(postes);
    }

    @Override
    public PostesDTO update(PostesDTO postesDTO) {
        log.debug("Request to save Postes : {}", postesDTO);
        Postes postes = postesMapper.toEntity(postesDTO);
        postes = postesRepository.save(postes);
        return postesMapper.toDto(postes);
    }

    @Override
    public Optional<PostesDTO> partialUpdate(PostesDTO postesDTO) {
        log.debug("Request to partially update Postes : {}", postesDTO);

        return postesRepository
            .findById(postesDTO.getId())
            .map(existingPostes -> {
                postesMapper.partialUpdate(existingPostes, postesDTO);

                return existingPostes;
            })
            .map(postesRepository::save)
            .map(postesMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PostesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Postes");
        return postesRepository.findAll(pageable).map(postesMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PostesDTO> findOne(Long id) {
        log.debug("Request to get Postes : {}", id);
        return postesRepository.findById(id).map(postesMapper::toDto);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<PostesDTO> findByCodePostes(String code) {
        log.debug("Request to get Postes : {}", code);
        return postesRepository.findByCodePostes(code).map(postesMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Postes : {}", id);
        postesRepository.deleteById(id);
    }
    @Override
    @Transactional(readOnly = true)
    public List<PostesDTO> listPostes() {
        return postesRepository.listPostes().stream().map(postesMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }
}
