package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Direction;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Direction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {
    @Query("SELECT direction FROM Direction direction WHERE direction.code= ?1")
    public Optional<Direction> findByCode(String code);

    @Query("SELECT direction FROM Direction direction WHERE direction.libelle= ?1")
    public Optional<Direction> findByLibelle(String libelle);

    @Query("SELECT direction FROM Direction direction")
    public List<Direction> findAllDirections();

}
