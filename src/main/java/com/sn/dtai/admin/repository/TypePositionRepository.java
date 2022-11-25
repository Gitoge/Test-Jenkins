package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.TypePosition;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TypePosition entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypePositionRepository extends JpaRepository<TypePosition, Long> {}
