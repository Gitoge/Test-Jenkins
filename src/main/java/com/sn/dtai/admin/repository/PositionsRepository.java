package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Positions;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Positions entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PositionsRepository extends JpaRepository<Positions, Long> {

    @Query("SELECT positions FROM Positions positions")
    public List<Positions> findAllPositions();
}
