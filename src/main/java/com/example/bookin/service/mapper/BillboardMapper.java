package com.example.bookin.service.mapper;

import com.example.bookin.entity.BillboardEntity;
import com.example.bookin.service.dto.BillboardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillboardMapper {
    BillboardEntity toBillboardEntity(BillboardDto billboardDto);

    BillboardDto toBillboardDto(BillboardEntity billboardEntity);
}
