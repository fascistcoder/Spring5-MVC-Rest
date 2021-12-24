package com.example.api.v1.mapper;

import com.example.api.v1.model.CategoryDTO;
import com.example.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 14/12/21
 */

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source ="id", target="id")
    CategoryDTO categoryToCategoryDTO(Category category);
}