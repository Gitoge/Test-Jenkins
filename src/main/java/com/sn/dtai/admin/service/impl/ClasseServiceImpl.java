package com.sn.dtai.admin.service.impl;

import com.sn.dtai.admin.domain.Classe;
import com.sn.dtai.admin.repository.ClasseRepository;
import com.sn.dtai.admin.service.ClasseService;
import com.sn.dtai.admin.service.dto.ClasseDTO;
import com.sn.dtai.admin.service.mapper.ClasseMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Classe}.
 */
@Service
@Transactional
public class ClasseServiceImpl implements ClasseService {

    private final Logger log = LoggerFactory.getLogger(ClasseServiceImpl.class);

    private final ClasseRepository classeRepository;

    private final ClasseMapper classeMapper;

    public ClasseServiceImpl(ClasseRepository classeRepository, ClasseMapper classeMapper) {
        this.classeRepository = classeRepository;
        this.classeMapper = classeMapper;
    }

    @Override
    public ClasseDTO save(ClasseDTO classeDTO) {
        log.debug("Request to save Classe : {}", classeDTO);
        Classe classe = classeMapper.toEntity(classeDTO);
        classe = classeRepository.save(classe);
        return classeMapper.toDto(classe);
    }

    @Override
    public ClasseDTO update(ClasseDTO classeDTO) {
        log.debug("Request to save Classe : {}", classeDTO);
        Classe classe = classeMapper.toEntity(classeDTO);
        classe = classeRepository.save(classe);
        return classeMapper.toDto(classe);
    }

    @Override
    public Optional<ClasseDTO> partialUpdate(ClasseDTO classeDTO) {
        log.debug("Request to partially update Classe : {}", classeDTO);

        return classeRepository
            .findById(classeDTO.getId())
            .map(existingClasse -> {
                classeMapper.partialUpdate(existingClasse, classeDTO);

                return existingClasse;
            })
            .map(classeRepository::save)
            .map(classeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClasseDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Classes");
        return classeRepository.findAll(pageable).map(classeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClasseDTO> findOne(Long id) {
        log.debug("Request to get Classe : {}", id);
        return classeRepository.findById(id).map(classeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Classe : {}", id);
        classeRepository.deleteById(id);
    }

     // M??thodes Ajout??es

    /**
     * Get one Classe by  code.
     *
     * @param code the code of the Classe.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Classe> findByCode(String code) {
        log.debug("Request to get Classe : {}", code);
        return classeRepository.findByCode( code);    
           
    }
 
    /**
      * Get one Etablissement by Libelle.
      *
      * @param Libelle the Libelle of the etablissement.
      * @return the entity.
      */
     @Transactional(readOnly = true)
     public Optional<Classe> findByLibelle(String libelle) {
         log.debug("Request to get Classe : {}", libelle);
         return classeRepository.findByLibelle( libelle);
            // .map(applicationsMapper::toDto);
     }
}
