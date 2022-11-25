package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.TypeDestinataires;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TypeDestinataires entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeDestinatairesRepository extends JpaRepository<TypeDestinataires, Long> {}
