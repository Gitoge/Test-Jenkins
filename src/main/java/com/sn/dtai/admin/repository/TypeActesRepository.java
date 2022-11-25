package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.TypeActes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TypeActes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeActesRepository extends JpaRepository<TypeActes, Long> {}
