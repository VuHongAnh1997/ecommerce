package com.diepvusinhtu1.ecommerce.controller;

import com.diepvusinhtu1.ecommerce.service.*;
import com.diepvusinhtu1.ecommerce.service.dto.*;
import com.diepvusinhtu1.ecommerce.service.mapper.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("/api/menu")
public class MenuController {


    private final MenuService menuService;

    private final MenuMapper menuMapper;

    public MenuController(MenuService menuService, MenuMapper menuMapper) {
        this.menuService = menuService;
        this.menuMapper = menuMapper;
    }

    @RequestMapping("/by-user/")
    public ResponseEntity<List<MenuDTO>> getMenuByUser(@RequestParam Long roleID) {
        return new ResponseEntity<>(menuService.getMenuByUser(roleID).stream().map(menuMapper::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }
}
