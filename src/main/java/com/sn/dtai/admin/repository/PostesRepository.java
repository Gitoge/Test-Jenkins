package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Postes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data SQL repository for the Postes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PostesRepository extends JpaRepository<Postes, Long> {

@Query("SELECT postes FROM Postes postes WHERE postes.code = ?1 ")
public Optional<Postes> findByCodePostes(String code);

// lister le nombre de postes sans pagination
@Query("SELECT p FROM Postes p order by code")
public List<Postes> listPostes();

}
