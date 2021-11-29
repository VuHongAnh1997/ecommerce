package com.diepvusinhtu1.ecommerce.service.mapper;

import com.diepvusinhtu1.ecommerce.entity.*;
import com.diepvusinhtu1.ecommerce.service.dto.*;
import org.mapstruct.*;

import java.util.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDto(Category category);

    List<Category> toEntityList(List<CategoryDTO> categoryDTOList);

    List<CategoryDTO> toDtoList(List<Category> categoryList);
}
