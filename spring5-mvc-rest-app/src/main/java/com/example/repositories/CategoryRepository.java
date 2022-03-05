package com.example.repositories;

import com.example.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 14/12/21
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
