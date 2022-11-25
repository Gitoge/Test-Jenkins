package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.ParamBaremeImposable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ParamBaremeImposable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ParamBaremeImposableRepository extends JpaRepository<ParamBaremeImposable, Long> {}
