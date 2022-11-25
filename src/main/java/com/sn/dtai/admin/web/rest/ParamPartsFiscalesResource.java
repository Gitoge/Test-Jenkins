package com.sn.dtai.admin.web.rest;

import com.sn.dtai.admin.repository.ParamPartsFiscalesRepository;
import com.sn.dtai.admin.service.ParamPartsFiscalesService;
import com.sn.dtai.admin.service.dto.ParamPartsFiscalesDTO;
import com.sn.dtai.admin.service.impl.ParamPartsFiscalesServiceImpl;
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
 * REST controller for managing {@link com.sn.dtai.admin.domain.ParamPartsFiscales}.
 */
@RestController
@RequestMapping("/api")
public class ParamPartsFiscalesResource {

    private final Logger log = LoggerFactory.getLogger(ParamPartsFiscalesResource.class);

    private static final String ENTITY_NAME = "adminParamPartsFiscales";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ParamPartsFiscalesService paramPartsFiscalesService;

    private final ParamPartsFiscalesServiceImpl paramPartsFiscalesServiceImpl;

    private final ParamPartsFiscalesRepository paramPartsFiscalesRepository;

    public ParamPartsFiscalesResource(
        ParamPartsFiscalesService paramPartsFiscalesService,
        ParamPartsFiscalesRepository paramPartsFiscalesRepository,
        ParamPartsFiscalesServiceImpl paramPartsFiscalesServiceImpl
    ) {
        this.paramPartsFiscalesService = paramPartsFiscalesService;
        this.paramPartsFiscalesRepository = paramPartsFiscalesRepository;
        this.paramPartsFiscalesServiceImpl = paramPartsFiscalesServiceImpl;
    }

    /**
     * {@code POST  /param-parts-fiscales} : Create a new paramPartsFiscales.
     *
     * @param paramPartsFiscalesDTO the paramPartsFiscalesDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new paramPartsFiscalesDTO, or with status {@code 400 (Bad Request)} if the paramPartsFiscales has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/param-parts-fiscales")
    public ResponseEntity<ParamPartsFiscalesDTO> createParamPartsFiscales(@Valid @RequestBody ParamPartsFiscalesDTO paramPartsFiscalesDTO)
        throws URISyntaxException {
        log.debug("REST request to save ParamPartsFiscales : {}", paramPartsFiscalesDTO);
        if (paramPartsFiscalesDTO.getId() != null) {
            throw new BadRequestAlertException("A new paramPartsFiscales cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ParamPartsFiscalesDTO result = paramPartsFiscalesService.save(paramPartsFiscalesDTO);
        return ResponseEntity
            .created(new URI("/api/param-parts-fiscales/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /param-parts-fiscales/:id} : Updates an existing paramPartsFiscales.
     *
     * @param id the id of the paramPartsFiscalesDTO to save.
     * @param paramPartsFiscalesDTO the paramPartsFiscalesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paramPartsFiscalesDTO,
     * or with status {@code 400 (Bad Request)} if the paramPartsFiscalesDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the paramPartsFiscalesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/param-parts-fiscales/{id}")
    public ResponseEntity<ParamPartsFiscalesDTO> updateParamPartsFiscales(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ParamPartsFiscalesDTO paramPartsFiscalesDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ParamPartsFiscales : {}, {}", id, paramPartsFiscalesDTO);
        if (paramPartsFiscalesDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, paramPartsFiscalesDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!paramPartsFiscalesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ParamPartsFiscalesDTO result = paramPartsFiscalesService.update(paramPartsFiscalesDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, paramPartsFiscalesDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /param-parts-fiscales/:id} : Partial updates given fields of an existing paramPartsFiscales, field will ignore if it is null
     *
     * @param id the id of the paramPartsFiscalesDTO to save.
     * @param paramPartsFiscalesDTO the paramPartsFiscalesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paramPartsFiscalesDTO,
     * or with status {@code 400 (Bad Request)} if the paramPartsFiscalesDTO is not valid,
     * or with status {@code 404 (Not Found)} if the paramPartsFiscalesDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the paramPartsFiscalesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/param-parts-fiscales/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ParamPartsFiscalesDTO> partialUpdateParamPartsFiscales(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ParamPartsFiscalesDTO paramPartsFiscalesDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ParamPartsFiscales partially : {}, {}", id, paramPartsFiscalesDTO);
        if (paramPartsFiscalesDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, paramPartsFiscalesDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!paramPartsFiscalesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ParamPartsFiscalesDTO> result = paramPartsFiscalesService.partialUpdate(paramPartsFiscalesDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, paramPartsFiscalesDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /param-parts-fiscales} : get all the paramPartsFiscales.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paramPartsFiscales in body.
     */
    @GetMapping("/param-parts-fiscales")
    public ResponseEntity<List<ParamPartsFiscalesDTO>> getAllParamPartsFiscales(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of ParamPartsFiscales");
        Page<ParamPartsFiscalesDTO> page = paramPartsFiscalesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /param-parts-fiscales/:id} : get the "id" paramPartsFiscales.
     *
     * @param id the id of the paramPartsFiscalesDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paramPartsFiscalesDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/param-parts-fiscales/{id}")
    public ResponseEntity<ParamPartsFiscalesDTO> getParamPartsFiscales(@PathVariable Long id) {
        log.debug("REST request to get ParamPartsFiscales : {}", id);
        Optional<ParamPartsFiscalesDTO> paramPartsFiscalesDTO = paramPartsFiscalesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paramPartsFiscalesDTO);
    }

    /**
     * {@code DELETE  /param-parts-fiscales/:id} : delete the "id" paramPartsFiscales.
     *
     * @param id the id of the paramPartsFiscalesDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/param-parts-fiscales/{id}")
    public ResponseEntity<Void> deleteParamPartsFiscales(@PathVariable Long id) {
        log.debug("REST request to delete ParamPartsFiscales : {}", id);
        paramPartsFiscalesService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

    /**
     * {@code GET  /param-parts-fiscales/code} : get the "id" paramPartsFiscales by code.
     *
     * @param id the id of the paramPartsFiscalesDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paramPartsFiscalesDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/param-parts-fiscales/code")
    public ResponseEntity<ParamPartsFiscalesDTO> getParamPartsFiscalesByCode(@RequestParam(value = "code") String code) {
        log.debug("REST request to get ParamPartsFiscales : {}", code);
        Optional<ParamPartsFiscalesDTO> paramPartsFiscalesDTO = paramPartsFiscalesServiceImpl.findByCode(code);
        return ResponseUtil.wrapOrNotFound(paramPartsFiscalesDTO);
    }
}
