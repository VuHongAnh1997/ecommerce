package com.diepvusinhtu1.ecommerce.service.mapper;

import com.diepvusinhtu1.ecommerce.entity.*;
import com.diepvusinhtu1.ecommerce.service.dto.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleDTO roleDTO);

    RoleDTO toDto(Role role);
}
