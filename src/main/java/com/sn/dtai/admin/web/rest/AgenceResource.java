package com.sn.dtai.admin.web.rest;

import com.sn.dtai.admin.domain.Agence;
import com.sn.dtai.admin.repository.AgenceRepository;
import com.sn.dtai.admin.service.AgenceService;
import com.sn.dtai.admin.service.dto.AgenceDTO;
import com.sn.dtai.admin.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.sn.dtai.admin.domain.Agence}.
 */
@RestController
@RequestMapping("/api")
public class AgenceResource {

    private final Logger log = LoggerFactory.getLogger(AgenceResource.class);

    private static final String ENTITY_NAME = "carriereAgence";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AgenceService agenceService;

    private final AgenceRepository agenceRepository;

    public AgenceResource(
        AgenceService agenceService,
        AgenceRepository agenceRepository
    ) {
        this.agenceService = agenceService;
        this.agenceRepository = agenceRepository;
    }

    /**
     * {@code POST  /agence} : Create a new agence.
     *
     * @param agenceDTO the agenceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new agenceDTO, or with status {@code 400 (Bad Request)} if the agence has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/agence")
    public ResponseEntity<AgenceDTO> createAgence(
        @Valid @RequestBody AgenceDTO agenceDTO
    ) throws URISyntaxException {
        log.debug("REST request to save Agence : {}", agenceDTO);
        if (agenceDTO.getId() != null) {
            throw new BadRequestAlertException("A new agence cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AgenceDTO result = agenceService.save(agenceDTO);
        return ResponseEntity
            .created(new URI("/api/agence/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /agence/:id} : Updates an existing agence.
     *
     * @param id the id of the agenceDTO to save.
     * @param agenceDTO the agenceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated agenceDTO,
     * or with status {@code 400 (Bad Request)} if the agenceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the agenceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/agence/{id}")
    public ResponseEntity<AgenceDTO> updateAgence(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody AgenceDTO agenceDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Agence : {}, {}", id, agenceDTO);
        if (agenceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, agenceDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!agenceRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        AgenceDTO result = agenceService.save(agenceDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, agenceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /agence/:id} : Partial updates given fields of an existing agence, field will ignore if it is null
     *
     * @param id the id of the agenceDTO to save.
     * @param agenceDTO the agenceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated agenceDTO,
     * or with status {@code 400 (Bad Request)} if the agenceDTO is not valid,
     * or with status {@code 404 (Not Found)} if the agenceDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the agenceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/agence/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<AgenceDTO> partialUpdateAgence(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody AgenceDTO agenceDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Agence partially : {}, {}", id, agenceDTO);
        if (agenceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, agenceDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!agenceRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<AgenceDTO> result = agenceService.partialUpdate(agenceDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, agenceDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /agence} : get all the agences.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of agences in body.
     */
    @GetMapping("/agence")
    public ResponseEntity<List<AgenceDTO>> getAllAgences(Pageable pageable) {
        log.debug("REST request to get a page of Agences");
        Page<AgenceDTO> page = agenceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /agence/:id} : get the "id" agence.
     *
     * @param id the id of the agenceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the agenceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/agence/{id}")
    public ResponseEntity<AgenceDTO> getAgence(@PathVariable Long id) {
        log.debug("REST request to get Agence : {}", id);
        try{
        Optional<AgenceDTO> agenceDTO = agenceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(agenceDTO);
        }
        catch(Exception e){
            throw new BadRequestAlertException("Agence Introuvable", ENTITY_NAME,"Agence Introuvable");
        }
    }

    /**
     * {@code DELETE  /agence/:id} : delete the "id" agence.
     *
     * @param id the id of the agenceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/agence/{id}")
    public ResponseEntity<Void> deleteAgence(@PathVariable Long id) {
        log.debug("REST request to delete Agence : {}", id);
        agenceService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

        /**
     * {@code GET  /agence} : get all the agence.
     *
     * 
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of agence in body.
     */
    @GetMapping("/agence/all")
    public List<Agence> getAllAgences() {
        return agenceRepository.findAllAgences();
    }
}
