package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.PostesNonCumulable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the PostesNonCumulable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PostesNonCumulableRepository extends JpaRepository<PostesNonCumulable, Long> {}
