package com.sn.dtai.admin.repository;

import com.sn.dtai.admin.domain.Categories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Categories entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    @Query("SELECT categories FROM Categories categories")
    public List<Categories> findAllCategories();
}
