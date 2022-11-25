package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.TypeReglement;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TypeReglement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeReglementRepository extends JpaRepository<TypeReglement, Long> {}
