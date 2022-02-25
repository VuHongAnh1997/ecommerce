package com.diepvusinhtu1.ecommerce.repository;

import com.diepvusinhtu1.ecommerce.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(String categoryName);

    List<Category> findByMenuPath(Long menuPath);

}
