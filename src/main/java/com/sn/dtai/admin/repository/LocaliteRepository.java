package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Localite;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Localite entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LocaliteRepository extends JpaRepository<Localite, Long> {

    @Query(value="SELECT l FROM Localite l INNER JOIN TypeLocalite tl ON (l.typeLocalite.id = tl.id) WHERE tl.code=:codeTypeLocalite ORDER BY l.libelle ASC")
    List<Localite> findAllByTypeLocalite(@Param("codeTypeLocalite") String codeTypeLocalite);

    @Query(value="SELECT l FROM Localite l WHERE l.localites.id=:localite")
    List<Localite> findAllByRattachement(@Param("localite") Long localite);

    @Query("SELECT localite FROM Localite localite WHERE localite.code= ?1")
    public Optional<Localite> findByCode(String code);

    @Query("SELECT localite FROM Localite localite WHERE localite.libelle= ?1")
    public Optional<Localite> findByLibelle(String libelle);
}
