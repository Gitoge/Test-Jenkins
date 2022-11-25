package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Indices;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * Spring Data SQL repository for the Indices entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IndicesRepository extends JpaRepository<Indices, Long> {
}
