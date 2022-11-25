package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Destinataires;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Destinataires entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DestinatairesRepository extends JpaRepository<Destinataires, Long> {}
