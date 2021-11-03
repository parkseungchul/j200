package com.psc.sample.j206.dto;

import com.psc.sample.j206.domain.DeptEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DeptMapper {

    @Mappings({
            @Mapping(target = "dtoValue", ignore = true)
    })
    Dept entityToDto(DeptEntity deptEntity);

    @Mappings({
            @Mapping(target = "entityValue", ignore = true)
    })
    DeptEntity dtoToEntity(Dept dept);
}
