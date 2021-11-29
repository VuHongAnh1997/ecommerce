package com.diepvusinhtu1.ecommerce.repository;

import com.diepvusinhtu1.ecommerce.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
