package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.NatureActes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the NatureActes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NatureActesRepository extends JpaRepository<NatureActes, Long> {}
