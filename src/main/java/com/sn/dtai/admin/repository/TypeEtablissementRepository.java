package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.TypeEtablissement;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TypeEtablissement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeEtablissementRepository extends JpaRepository<TypeEtablissement, Long> {

    @Query("SELECT typeEtablissement FROM TypeEtablissement typeEtablissement WHERE typeEtablissement.code= ?1")
    public Optional<TypeEtablissement> findByCode(String code);

    @Query("SELECT typeEtablissement FROM TypeEtablissement typeEtablissement WHERE typeEtablissement.libelle= ?1")
    public Optional<TypeEtablissement> findByLibelle(String libelle);
}
