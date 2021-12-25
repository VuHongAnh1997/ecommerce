package com.diepvusinhtu1.ecommerce.service;

import com.diepvusinhtu1.ecommerce.entity.*;
import com.diepvusinhtu1.ecommerce.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class MenuService {
    private final MenuRepository menuRepository;


    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getMenuByUser(Long roleID) {
        return menuRepository.findByRoleID(roleID);
    }
}
