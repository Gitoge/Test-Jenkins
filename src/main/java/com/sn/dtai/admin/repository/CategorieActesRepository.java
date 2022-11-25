package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.CategorieActes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the CategorieActes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategorieActesRepository extends JpaRepository<CategorieActes, Long> {}
