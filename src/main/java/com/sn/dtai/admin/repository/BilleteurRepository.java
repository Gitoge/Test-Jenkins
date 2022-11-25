package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Billeteur;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Billeteur entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BilleteurRepository extends JpaRepository<Billeteur, Long> {

    @Query("SELECT billeteur FROM Billeteur billeteur")
    public List<Billeteur> findAllBilleteurs();
}
