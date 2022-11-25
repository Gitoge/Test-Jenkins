package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Classe;

import java.util.Optional;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Classe entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    @Query("SELECT classe FROM Classe classe WHERE classe.code= ?1")
    public Optional<Classe> findByCode(String code);

    @Query("SELECT classe FROM Classe classe WHERE classe.libelle= ?1")
    public Optional<Classe> findByLibelle(String libelle);

    
    @Query("SELECT classe FROM Classe classe")
    public List<Classe> findAllClasse();


}
