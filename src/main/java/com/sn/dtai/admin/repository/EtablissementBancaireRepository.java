package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.EtablissementBancaire;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the EtablissementBancaire entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EtablissementBancaireRepository extends JpaRepository<EtablissementBancaire, Long> {
    
    @Query("SELECT etablissementBancaire FROM EtablissementBancaire etablissementBancaire")
    public List<EtablissementBancaire> findAllEtablissementBancaires();
}
