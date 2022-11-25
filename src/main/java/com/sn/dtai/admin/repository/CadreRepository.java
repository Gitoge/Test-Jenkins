package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Cadre;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Cadre entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CadreRepository extends JpaRepository<Cadre, Long> {}
