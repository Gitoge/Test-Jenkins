package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Roles;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Roles entity.
 */
@Repository
public interface RolesRepository extends RolesRepositoryWithBagRelationships, JpaRepository<Roles, Long> {
    default Optional<Roles> findOneWithEagerRelationships(Long id) {
        return this.fetchBagRelationships(this.findById(id));
    }

    default List<Roles> findAllWithEagerRelationships() {
        return this.fetchBagRelationships(this.findAll());
    }

    default Page<Roles> findAllWithEagerRelationships(Pageable pageable) {
        return this.fetchBagRelationships(this.findAll(pageable));
    }

    @Query("SELECT roles FROM Roles roles WHERE roles.code= ?1")
    public Optional<Roles> findByCode(String code);

    @Query("SELECT roles FROM Roles roles WHERE roles.libelle= ?1")
    public Optional<Roles> findByLibelle(String libelle);

    //AREVOIR @Query("SELECT roles FROM Roles roles LEFT JOIN FETCH roles.profils profil WHERE profil.id = ?1  ")
    @Query("SELECT roles FROM Roles roles  ")
    public List<Roles> findByProfil(Long profilId);
}
