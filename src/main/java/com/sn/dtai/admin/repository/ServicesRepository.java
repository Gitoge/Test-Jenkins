package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Service entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    @Query("SELECT services FROM Services services WHERE services.code= ?1")
    public Optional<Services> findByCode(String code);

    @Query("SELECT services FROM Services services WHERE services.libelle= ?1")
    public Optional<Services> findByLibelle(String libelle);

    @Query("SELECT services FROM Services services JOIN Direction as direction on ( direction = services.direction )  JOIN Etablissement as etablissement on ( etablissement = direction.etab  ) WHERE etablissement.id= ?1")
    public List<Services> findByEtablissement(Long etablissementId);

    
    @Query("SELECT services FROM Services services")
    public List<Services> findAllServices();
}
