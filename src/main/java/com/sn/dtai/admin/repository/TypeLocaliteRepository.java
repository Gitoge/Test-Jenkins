package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.TypeLocalite;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TypeLocalite entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeLocaliteRepository extends JpaRepository<TypeLocalite, Long> {
    @Query("SELECT typeLocalite FROM TypeLocalite typeLocalite WHERE typeLocalite.code= ?1")
    public Optional<TypeLocalite> findByCode(String code);

    @Query("SELECT typeLocalite FROM TypeLocalite typeLocalite WHERE typeLocalite.libelle= ?1")
    public Optional<TypeLocalite> findByLibelle(String libelle);
}
