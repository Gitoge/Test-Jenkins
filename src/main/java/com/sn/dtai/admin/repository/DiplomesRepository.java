package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Diplomes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Diplomes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DiplomesRepository extends JpaRepository<Diplomes, Long> {}
