package com.diepvusinhtu1.ecommerce.repository;

import com.diepvusinhtu1.ecommerce.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByRoleID(Long roleID);
}
